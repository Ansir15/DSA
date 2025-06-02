//import java.util.Scanner;
//
//class Node{
//    int data;
//    Node left,right;
//
//    public Node(int data) {
//        this.data = data;
//        this.right=null;
//        this.left=null;
//    }
//
//}
//class BinarySearchTree{
//    Node root;
//
//    public Node insertNode(Node node, int key) {
//    if (node == null) {
//        return new Node(key);
//    }
//
//    if (key < node.data) {
//        node.left = insertNode(node.left, key);
//    } else if (key > node.data) {
//        node.right = insertNode(node.right, key);
//    }
//
//    return node;
//}
//    public void insert(int key) {
//        root = insertNode(root, key);
//    }
//    public boolean searchNode(Node node, int key) {
//        if (node == null)
//            return false;
//        if (node.data == key)
//            return true;
//        if (key < node.data)
//            return searchNode(node.left, key);
//        else {
//            return searchNode(node.right, key);
//        }
//    }
//
//    public boolean search(int key) {
//        return searchNode(root, key);
//    }
//}
//public class Task1{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        BinarySearchTree tree=new BinarySearchTree();
//        while (true){
//            System.out.println("binary search tree operation");
//            System.out.println("1.insert a node");
//            System.out.println("2.search node");
//            System.out.println("3.Exit");
//            System.out.println("Enter your choice");
//
//            int choice=sc.nextInt();
//
//            switch (choice){
//                case 1:
//                    System.out.println("Enter value to insert");
//                    int insertValue=sc.nextInt();
//                    tree.insert(insertValue);
//                    System.out.println(insertValue +" inserted successfuly");
//                    break;
//
//                case 2:
//                    System.out.println("Enter value to search");
//                    int valueSearch=sc.nextInt();
//                    boolean found=tree.search(valueSearch);
//                    System.out.println(valueSearch+ " is " +(found?"":"not")+" found in the tree");
//                      break;
//                case 3:
//                    System.out.println("Exit the program");
//                    break;
//                default:
//                    System.out.println("invalid choice : please try again");
//            }
//        }
//
//
//
//
//    }
//}