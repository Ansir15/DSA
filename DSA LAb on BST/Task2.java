//class Node{
//    int data;
//    Node left,right;
//
//    public Node(int data) {
//        this.data = data;
//        this.right=null;
//        this.left=null;
//    }
//}
//class BinarySearchTree {
//    Node root;
//
//    public Node insertNode(Node node, int key) {
//        if (node == null) {
//            return new Node(key);
//        }
//
//        if (key < node.data) {
//            node.left = insertNode(node.left, key);
//        } else if (key > node.data) {
//            node.right = insertNode(node.right, key);
//        }
//
//        return node;
//    }
//
//    public void insert(int key) {
//        root = insertNode(root, key);
//    }
//
//    public void InorderTraversal(Node node){
//        if(node!=null){
//            InorderTraversal(node.left);
//            System.out.print(node.data+" ");
//            InorderTraversal(node.right);
//        }
//    }
//    public void Display(){
//        System.out.print("inorder traversal: ");
//        InorderTraversal(root);
//    }
//}
//public class Task2 {
//    public static void main(String[] args) {
//        BinarySearchTree tree=new BinarySearchTree();
//
//        int[] value={60,50,70,30,55,80,35,57,75,32,40,77,48,45};
//        for (int k:value){
//            tree.insert(k);
//        }
//        tree.Display();
//    }
//}
