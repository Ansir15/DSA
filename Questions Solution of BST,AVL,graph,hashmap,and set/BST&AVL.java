//class Node {
//    int transactionID;
//    Node left, right;
//
//    public Node(int id) {
//        this.transactionID = id;
//        this.left = this.right = null;
//    }
//}
//
//class FraudDetectionSystem {
//    Node root;
//
//    public boolean isValidID(int id) {
//        return id >= 100000 && id <= 999999;
//    }
//
//    public void insert(int id) {
//        if (!isValidID(id)) {
//            System.out.println("Invalid ID: Out of range.");
//            return;
//        }
//        if (search(root, id)) {
//            System.out.println("Transaction already flagged.");
//            return;
//        }
//        root = insertRecursive(root, id);
//        checkAVLBalance(root);
//    }
//
//    private Node insertRecursive(Node node, int id) {
//        if (node == null) return new Node(id);
//        if (id < node.transactionID)
//            node.left = insertRecursive(node.left, id);
//        else
//            node.right = insertRecursive(node.right, id);
//        return node;
//    }
//
//    public void delete(int id) {
//        if (!search(root, id)) {
//            System.out.println("Transaction not found.");
//            return;
//        }
//        root = deleteRecursive(root, id);
//        checkAVLBalance(root);
//    }
//
//    private Node deleteRecursive(Node node, int id) {
//        if (node == null) return null;
//
//        if (id < node.transactionID)
//            node.left = deleteRecursive(node.left, id);
//        else if (id > node.transactionID)
//            node.right = deleteRecursive(node.right, id);
//        else {
//            if (node.left == null) return node.right;
//            else if (node.right == null) return node.left;
//
//            node.transactionID = minValue(node.right);
//            node.right = deleteRecursive(node.right, node.transactionID);
//        }
//        return node;
//    }
//
//    public boolean search(Node node, int id) {
//        if (node == null) return false;
//        if (id == node.transactionID) return true;
//        return id < node.transactionID ? search(node.left, id) : search(node.right, id);
//    }
//
//    public void preorder(Node node) {
//        if (node == null) return;
//        System.out.print(node.transactionID + " ");
//        preorder(node.left);
//        preorder(node.right);
//    }
//
//    public int minValue(Node node) {
//        while (node.left != null) node = node.left;
//        return node.transactionID;
//    }
//
//    public int maxValue(Node node) {
//        while (node.right != null) node = node.right;
//        return node.transactionID;
//    }
//
//    public int getHeight(Node node) {
//        if (node == null) return 0;
//        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
//    }
//
//    public void checkAVLBalance(Node node) {
//        if (isAVL(node))
//            System.out.println("Tree is AVL Balanced.");
//        else
//            System.out.println("Tree is NOT AVL Balanced.");
//    }
//
//    public boolean isAVL(Node node) {
//        if (node == null) return true;
//        int balance = Math.abs(getHeight(node.left) - getHeight(node.right));
//        return balance <= 1 && isAVL(node.left) && isAVL(node.right);
//    }
//
//    // ======= MAIN TEST CASE (same as expected output) ========
//    public static void main(String[] args) {
//        FraudDetectionSystem tree = new FraudDetectionSystem();
//
//        tree.insert(250000);
//        tree.insert(150000);
//        tree.insert(100000);
//        tree.insert(350000);
//        tree.insert(400000);
//
//        System.out.print("Flagged Transactions (Preorder): ");
//        tree.preorder(tree.root);
//        System.out.println();
//
//        System.out.println("Is 150000 flagged? " + tree.search(tree.root, 150000));
//        System.out.println("Earliest flagged transaction ID: " + tree.minValue(tree.root));
//        System.out.println("Latest flagged transaction ID: " + tree.maxValue(tree.root));
//
//        System.out.println("Unflagging 150000");
//        tree.delete(150000);
//
//        System.out.print("Flagged Transactions (Preorder): ");
//        tree.preorder(tree.root);
//        System.out.println();
//    }
//}
//
//
////=============================================================================
//
class Node {
    int rollNumber;
    Node left, right;

    public Node(int rollNumber) {
        this.rollNumber = rollNumber;
        left = right = null;
    }
}
class StudentRegistrationSystem {
    private Node root;

    // Register a student (insert into BST)
    public void registerStudent(int rollNumber) {
        // Validate roll number
        if (rollNumber < 1000 || rollNumber > 9999) {
            System.out.println("Invalid roll number: " + rollNumber);
            return;
        }

        // Check for duplicates
        if (searchStudent(rollNumber)) {
            System.out.println("Student already registered: " + rollNumber);
            return;
        }

        root = insert(root, rollNumber);
        checkAVLBalance();
    }

    private Node insert(Node node, int rollNumber) {
        if (node == null) {
            return new Node(rollNumber);
        }

        if (rollNumber < node.rollNumber) {
            node.left = insert(node.left, rollNumber);
        } else if (rollNumber > node.rollNumber) {
            node.right = insert(node.right, rollNumber);
        }

        return node;
    }

    // Drop a student (delete from BST)
    public void dropStudent(int rollNumber) {
        root = delete(root, rollNumber);
        checkAVLBalance();
    }

    private Node delete(Node node, int rollNumber) {
        if (node == null) {
            return null;
        }

        if (rollNumber < node.rollNumber) {
            node.left = delete(node.left, rollNumber);
        } else if (rollNumber > node.rollNumber) {
            node.right = delete(node.right, rollNumber);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get inorder successor
            node.rollNumber = minValue(node.right);

            // Delete the inorder successor
            node.right = delete(node.right, node.rollNumber);
        }

        return node;
    }

    private int minValue(Node node) {
        int minValue = node.rollNumber;
        while (node.left != null) {
            minValue = node.left.rollNumber;
            node = node.left;
        }
        return minValue;
    }

    // Search for a student
    public boolean searchStudent(int rollNumber) {
        return search(root, rollNumber);
    }

    private boolean search(Node node, int rollNumber) {
        if (node == null) {
            return false;
        }

        if (node.rollNumber == rollNumber) {
            return true;
        }

        return rollNumber < node.rollNumber
                ? search(node.left, rollNumber)
                : search(node.right, rollNumber);
    }

    // Check AVL balance of the entire tree
    private void checkAVLBalance() {
        if (isAVLBalanced(root)) {
            System.out.println("Tree is AVL Balanced.");
        }
    }

    private boolean isAVLBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isAVLBalanced(node.left) && isAVLBalanced(node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Display registered students in sorted order (in-order traversal)
    public void displayRegisteredStudents() {
        System.out.print("Registered Students (Sorted): ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.rollNumber + " ");
            inOrderTraversal(node.right);
        }
    }

    // Get smallest roll number
    public int getSmallestRollNumber() {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.rollNumber;
    }

    // Get largest roll number
    public int getLargestRollNumber() {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.rollNumber;
    }

    public static void main(String[] args) {
        StudentRegistrationSystem system = new StudentRegistrationSystem();

        // Register students
        system.registerStudent(4000);
        system.registerStudent(2000);
        system.registerStudent(6000);
        system.registerStudent(1000);
        system.registerStudent(3000);
        system.registerStudent(5000);
        system.registerStudent(7000);
        system.registerStudent(8000);

        // Try invalid and duplicate registrations
        system.registerStudent(999);
        system.registerStudent(4000);

        // Display registered students
        system.displayRegisteredStudents();

        // Search for students
        System.out.println("Is student 3000 registered? " + system.searchStudent(3000));
        System.out.println("Is student 9000 registered? " + system.searchStudent(9000));

        // Get smallest and largest roll numbers
        System.out.println("Smallest Roll Number: " + system.getSmallestRollNumber());
        System.out.println("Largest Roll Number: " + system.getLargestRollNumber());

        // Drop a student
        System.out.println("\nDropping 6000 --");
        system.dropStudent(6000);
        system.displayRegisteredStudents();
    }
}