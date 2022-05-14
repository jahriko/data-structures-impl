package DataStructures;

public class DoublyLinkedList <T> implements Iterable <T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node <T> previous;
        Node <T> next;
        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    //OPERATIONS

    public void clear() {
        Node <T> traverse = head;
        while (traverse != null) {
            Node <T> next = traverse.next;
            traverse.previous = traverse.next = null;
            traverse.data = null;
            traverse = next;
        }
        head = tail = traverse = null;
        size = 0;
    }

    // ○ : New DataStructures.Node
    // ⚫ : Existing DataStructures.Node
    public void addFirst(T element) {
        if (isEmpty()) {
            //  head     tail
            //   ○       ○
            head = tail = new Node<>(element, null, null);
        }
        else {
            //          Head
            //  ○  <->  ⚫
            head.previous = new Node<>(element, null, head);

            //  Head
            //   ○  <->  ⚫
            head = head.previous;
        }

        size++;
    }

    // ○ : New DataStructures.Node
    // ⚫ : Existing DataStructures.Node
    public void addLast(T element) {
        if (isEmpty()) {
            //  head     tail
            //   ○       ○
            head = tail = new Node<>(element, null, null);
        }
        else {
            //  Tail
            //   ⚫  <->  ○
            tail.next = new Node<>(element, tail, null);

            //          Tail
            //   ⚫  <->  ○
            tail = tail.next;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");

        T data = head.data;

        // head
        //  ⚫ <-> ⚫

        //       head
        //  ⚫ <-> ⚫
        head = head.next;
        --size;

        if (isEmpty()) tail = null;

        //         head
        //  ⚫  <->  ⚫

        //          head
        //  null  <- ⚫
        else head.previous = null;

        //Return the data that we removed
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
