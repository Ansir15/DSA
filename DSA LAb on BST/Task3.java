//
//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int data) {
//        this.data = data;
//        this.right = null;
//        this.left = null;
//    }
//}
//
//class BinarySearchTree {
//    Node root;
//
//    public Node insertNode(Node node, int key) {
//        if (node == null) {
//            return new Node(key);
//        }
//        if (key < node.data) {
//            node.left = insertNode(node.left, key);
//        } else if (key > node.data) {
//            node.right = insertNode(node.right, key);
//        }
//        return node;
//    }
//
//    public void insert(int key) {
//        root = insertNode(root, key);
//    }
//
//    // 1. Pre-Order Traversal
//    public void preOrderTraversal(Node node) {
//        if (node != null) {
//            System.out.print(node.data + " ");
//            preOrderTraversal(node.left);
//            preOrderTraversal(node.right);
//        }
//    }
//
//    // 2. In-Order Traversal
//    public void inOrderTraversal(Node node) {
//        if (node != null) {
//            inOrderTraversal(node.left);
//            System.out.print(node.data + " ");
//            inOrderTraversal(node.right);
//        }
//    }
//
//    // 3. Post-Order Traversal
//    public void postOrderTraversal(Node node) {
//        if (node != null) {
//            postOrderTraversal(node.left);
//            postOrderTraversal(node.right);
//            System.out.print(node.data + " ");
//        }
//    }
//
//    // Display all three orders
//    public void displayTraversals() {
//        System.out.println("Pre-Order Traversal: ");
//        preOrderTraversal(root);
//        System.out.println();
//
//        System.out.println("In-Order Traversal: ");
//        inOrderTraversal(root);
//        System.out.println();
//
//        System.out.println("Post-Order Traversal: ");
//        postOrderTraversal(root);
//        System.out.println();
//    }
//}
//
//public class Task3 {
//    public static void main(String[] args) {
//        BinarySearchTree tree=new BinarySearchTree();
//
//        int[] value={60,50,70,30,55,80,35,57,75,32,40,77,48,45};
//        for (int k:value){
//            tree.insert(k);
//        }
//        tree.displayTraversals();
//    }
//}
//
