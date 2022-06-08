package my_list.linked_list;

public class Node {
    private String value;
    private Node next;

    Node(String value) {
        this.value = value;
        this.next = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
