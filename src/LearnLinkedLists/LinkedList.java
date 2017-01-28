package LearnLinkedLists;

/**
 * About the code : LinkedList implementation
 */

class Node<E> {
    E data = null;
    Node next = null;

    public Node(E data) {
        this.data = data;
    }
}

public class LinkedList<E> {
    Node<E> head;

    public void append(E data) {
        if (head == null) {
            head = new Node<E>(data);
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(E data) {
        Node<E> newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(E data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node<E> current = head;
        while (current.next != null) {
            System.out.print(String.valueOf(current.data) + " ");
            current = current.next;
        }
        System.out.print(String.valueOf(current.data));
        System.out.println();
    }
}
