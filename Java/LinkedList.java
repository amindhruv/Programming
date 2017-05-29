public class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }

    static Node head;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            insertAtBeginning(i);
        print();
        insertAtEnd(10);
        print();
        insertAfterValue(9, 2);
        print();
        deleteAtBeginning();
        print();
        deleteAtEnd();
        print();
        deleteByValue(9);
        print();
        search(0);
        reversePrint(head);
    }

    private static void search(int desired) {
        if (isEmpty())
            System.out.println("List already empty!");
        else {
            Node current = head;
            while (current != null && current.data != desired)
                current = current.next;
            String flag = (current == null) ? "not " : "";
            System.out.println(desired + " is " + flag + "present in the list.");
        }
    }

    private static void deleteByValue(int desired) {
        if (isEmpty())
            System.out.println("List already empty!");
        else if (head.data == desired)
            head = head.next;
        else {
            Node current = head, prev = null;
            while (current != null && current.data != desired) {
                prev = current;
                current = current.next;
            }
            if (current == null)
                System.out.println("Element " + desired + " is not in the list");
            else
                prev.next = current.next;
        }
    }

    private static void deleteAtEnd() {
        if (isEmpty())
            System.out.println("List already empty!");
        else if (head.next == null)
            head = head.next;
        else {
            Node current = head, prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }

    private static void deleteAtBeginning() {
        if (isEmpty())
            System.out.println("List already empty!");
        else
            head = head.next;
    }

    private static void insertAfterValue(int value, int desired) {
        Node current = head;
        while (current != null && current.data != desired)
            current = current.next;
        if (current == null)
            System.out.println("Element " + desired + " is not in the list!");
        else {
            Node temp = new Node(value);
            temp.next = current.next;
            current.next = temp;
        }
    }

    private static void insertAtEnd(int value) {
        if (head == null)
            head = new Node(value);
        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = new Node(value);
        }
    }

    private static void print() {
        if (isEmpty())
            System.out.println("Empty list!");
        else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    private static boolean isEmpty() {
        return head == null;
    }

    private static void insertAtBeginning(int value) {
        Node temp = new Node(value);
        temp.next = head;
        head = temp;
    }

    private static void reversePrint(Node head) {
        if (head != null) {
            reversePrint(head.next);
            System.out.print(head.data + " ");
        }
    }
}