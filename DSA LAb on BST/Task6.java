class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class BinarySearchTree {
    Node root;

    public Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.data) {
            node.left = insertNode(node.left, key);
        } else if (key > node.data) {
            node.right = insertNode(node.right, key);
        }
        return node;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    public Node FindLowestAncestor(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (n1 < node.data && n2 < node.data) {
            return FindLowestAncestor(node.left, n1, n2);
        }
        if (n1 > node.data && n2 > node.data) {
            return FindLowestAncestor(node.right, n1, n2);
        }

        return node;
    }
}

public class Task6 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] value = {60, 50, 70, 30, 55, 80, 35, 57, 75, 32, 40, 77, 48, 45};
        for (int k : value) {
            tree.insert(k);
        }
        int n1 = 32;
        int n2 = 48;

        Node lca = tree.FindLowestAncestor(tree.root, n1, n2);

        if (lca != null) {
            System.out.println("Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("Lca not found");
        }
    }
}