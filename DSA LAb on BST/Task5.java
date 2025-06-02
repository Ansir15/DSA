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
//    //We use Integer (wrapper class) because we may need to return null
//    // which is not possible with primitive types like int.
//    public Integer findMin(){
//        if(root==null){
//            return null;
//        }
//        Node temp=root;
//        while (temp.left!=null){
//            temp=temp.left;
//        }
//        return temp.data;
//    }
//    public Integer findMax(){
//        if(root==null){
//            return null;
//        }
//        Node temp=root;
//        while (temp.right!=null){
//            temp=temp.right;
//        }
//        return temp.data;
//    }
//}
//
//
//
//public class Task5 {
//    public static void main(String[] args) {
//        BinarySearchTree tree=new BinarySearchTree();
//        int[] value={60,50,70,30,55,80,35,57,75,32,40,77,48,45};
//       for (int k:value){
//           tree.insert(k);
//       }
//
//       Integer min= tree.findMin();
//       Integer max= tree.findMax();
//if(min!=null && max!=null) {
//    System.out.println("maximum value in BST tree is: " + min);
//    System.out.println("minimum value in BST tree is: " + max);
//}
//else {
//    System.out.println("tree is empty: ");
//}
//    }
//}
