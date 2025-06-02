class Node{
    int data;
    Node left,right;

    public Node(int value) {
        this.data = value;
        this.right=null;
        this.left=null;
    }
}

class BinarySearchTree {
    Node root;

    // Make insertion private since it's a helper method
    private Node insertion(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data)
            root.left = insertion(root.left, value);
        else if (value > root.data)
            root.right = insertion(root.right, value);

        return root;
    }
    public void insert(int value) {
        this.root = insertion(this.root, value);
    }
    //Ye method user ke liye hai (jo main() me call hota hai).
    //Ye internally recursive insert ko root se call karta hai.

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void Inorder(Node root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void Display() {
        System.out.print("preorder:");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        Inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

    }

    boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.data) {
            return true;
        }
        if (key < node.data) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public Node  delete(Node root,int value){
        if(root==null){
            return root;
        }
        if(value>root.data){
            root.right=delete(root.right,value);
        } else if (value<root.data) {
            root.left=delete(root.left,value);
        }
        else {
            // case 1
            if(root.left==null && root.right== null){
                return null;
            }

            // case 2
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            else {
                root.data=minValue(root.right); // Find inorder successor
                root.right=delete(root.right,root.data); // Delete successor


                // root.data = maxValue(root.left); find inorder Predecessor
                //root.left = deleteUsingPredecessor(root.left, root.data); Delete Predecessor
            }
        }
        return root;
    }
  public int minValue(Node root) {
    while (root.left != null)
        root = root.left;
    return root.data;
}
}
// public  int maxValue(Node root) {
//    while (root.right != null)
//        root = root.right;
//    return root.data;
//}
//}

public class Main {
    public static void main(String[] args) {
BinarySearchTree tree=new BinarySearchTree();

tree.insert(8);
tree.insert( 5);
tree.insert(9);
tree.insert(2);
tree.insert(12);
tree.insert(34);
tree.insert(6);
tree.Display();

System.out.println("Search 60: " + tree.search(tree.root, 9));
 System.out.println("Search 25: " + tree.search(tree.root, 25));

 tree.root=tree.delete(tree.root,9);
 tree.Display();
    }
}