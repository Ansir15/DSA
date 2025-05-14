class browser {
    Node back;
    Node forward;
    String currentPage;

    private class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }
    public browser() {
        back = null;
        forward = null;
    }
    public void visit(String url) {
        if (currentPage != null) {
            Node newNode = new Node(currentPage);
            newNode.next = back;
            back=newNode;
        }
        forward = null;
        currentPage = url;
    }

    public void goBack() {
        if (back != null) {
//            Node newNode = new Node(current);
            Node newNode = new Node(currentPage);
            newNode.next = forward;
            forward = newNode;
            currentPage = back.url;
            back = back.next;
        }
    }

    public void goForward() {
        if (forward != null) {
            Node newNode = new Node(currentPage);
            newNode.next = back;
            back=newNode;
//            currentPage = forward.url;
//            forward = forward.next;
            currentPage = forward.url;
            forward = forward.next;
        }
    }

    public String showCurrentPage() {
        return currentPage;
    }
    public static void main(String[] args) {
        browser b = new browser();
        b.visit("google.com");
        b.visit("github.com");
        b.visit("stackoverflow.com");

        System.out.println(b.showCurrentPage());

        b.goBack();
        b.goBack();
        System.out.println(b.showCurrentPage());

        b.goForward();
        System.out.println(b.showCurrentPage());

        b.visit("oracle.com");
        System.out.println(b.showCurrentPage());

        b.goForward();
        System.out.println(b.showCurrentPage());

        b.goBack();
        System.out.println(b.showCurrentPage());
    }
}