package DataStructures;

public class SinglyLinkedList<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void addFirstNode(T element) {
        if (isEmpty()) {
            head = new Node<>(element, head);
            tail = head;
        } else {
            Node<T> node = new Node<>(element, head);

            // Before :
            //       head
            //  ○    ⚫ -> ⚫ -> ...

            head = node;

            // After :
            // head
            //  ○  -> ⚫ -> ⚫ -> ...
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        //Node current will point to head
        Node<T> current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.data = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}

class Program {
    public static void main(String[] args) {
        SinglyLinkedList<String> linkedlist = new SinglyLinkedList<>();

        linkedlist.addFirstNode("Geeks");
        linkedlist.addFirstNode("for");
        linkedlist.addFirstNode("Geeks");
        linkedlist.addFirstNode("10");
        linkedlist.addFirstNode("20");

        linkedlist.display();

    }
}

