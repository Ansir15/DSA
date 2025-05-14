//import java.util.Stack;
//
//public class browser{
//    Stack<String> Back;
//    Stack<String> forward;
//    String currentPage;
//
//    public browser() {
//        Back = new Stack<>();
//        forward= new Stack<>();
//    }
//    public void visit(String url) {
//        if (currentPage != null) {
//            Back.push(currentPage);
//        }
//        forward.clear();
//        currentPage = url;
//    }
//    public void goBack() {
//        if (!Back.isEmpty()) {
//            forward.push(currentPage);
//            currentPage = Back.pop();
//        }
//        else {
//            System.out.println("back stack is empty:");
//        }
//    }
//    public void goForward() {
//        if (!forward.isEmpty()) {
//            Back.push(currentPage);
//            currentPage = forward.pop();
//        }
//    }
//    public String showCurrentPage() {
//        return currentPage;
//    }
//    public static void main(String[] args) {
//        browser b = new browser();
//        b.visit("google.com");
//        b.visit("github.com");
//        b.visit("stackoverflow.com");
//
//        System.out.println(b.showCurrentPage());
//        b.goBack();
//        b.goBack();
//
//        System.out.println(b.showCurrentPage());
//
//        b.goForward();
//        System.out.println(b.showCurrentPage());
//
//        b.visit("oracle.com");
//        System.out.println(b.showCurrentPage());
//
//        b.goForward();
//        System.out.println(b.showCurrentPage());
//        b.goBack();
//        System.out.println(b.showCurrentPage());
//    }
//}