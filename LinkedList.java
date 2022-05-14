package DataStructures;

public class LinkedList {
    Node head;

    public void add(Object data) {
        Node node = new Node();
        node.data = data;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
        }
    }
}

class Node {
    Object data;
    Node next;

    public Node() {
        this.data = data;
        this.next = next;
    }
}

class RunProgram {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
    }
}
