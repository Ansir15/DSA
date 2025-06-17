class AVLNode {
    String key;
    int height;
    AVLNode left, right;

    AVLNode(String key) {
        this.key = key;
        this.height = 1;
    }
}

class AVLTree {
    private AVLNode root;

    // Utility: get height
    int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Utility: get balance factor
    int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Utility: right rotate
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Utility: left rotate
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert
    public void insert(String key) {
        root = insert(root, key);
    }

    private AVLNode insert(AVLNode node, String key) {
        if (node == null) return new AVLNode(key);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Balancing
        if (balance > 1 && key.compareTo(node.left.key) < 0) return rightRotate(node);
        if (balance < -1 && key.compareTo(node.right.key) > 0) return leftRotate(node);
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Delete
    public void delete(String key) {
        root = delete(root, key);
    }

    private AVLNode delete(AVLNode node, String key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0)
            node.left = delete(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                AVLNode minLargerNode = getMinValueNode(node.right);
                node.key = minLargerNode.key;
                node.right = delete(node.right, minLargerNode.key);
            }
        }

        if (node == null) return null;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) return rightRotate(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) return leftRotate(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode getMinValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Search
    public boolean search(String key) {
        return search(root, key);
    }

    private boolean search(AVLNode node, String key) {
        if (node == null) return false;
        if (key.equals(node.key)) return true;
        return key.compareTo(node.key) < 0 ? search(node.left, key) : search(node.right, key);
    }

    // Inorder Traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Get overall tree height
    public int getHeight() {
        return height(root);
    }
}
public class AVL {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert("Banana");
        tree.insert("Apple");
        tree.insert("Mango");
        tree.insert("Peach");
        tree.insert("Cherry");

        tree.inorder();

        System.out.println("Search 'Mango': " + tree.search("Mango"));
        System.out.println("Search 'Grapes': " + tree.search("Grapes"));

        tree.delete("Peach");
        tree.inorder();

        System.out.println("Tree Height: " + tree.getHeight());
    }
}
//public class Main {
//    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//
//        // Insert numbers
//        int[] nums = {30, 10, 20, 5, 15, 40, 50, 25};
//
//        for (int n : nums) {
//            tree.insert(n);
//        }
//
//        tree.inorder();
//        System.out.println("Height of tree: " + tree.getHeight());
//
//        System.out.println("Search 15: " + tree.search(15));
//        System.out.println("Search 100: " + tree.search(100));
//
//        System.out.println("Deleting 20...");
//        tree.delete(20);
//        tree.inorder();
//
//        System.out.println("Deleting 10...");
//        tree.delete(10);
//        tree.inorder();
//
//        System.out.println("Final Height: " + tree.getHeight());
//    }
//}
