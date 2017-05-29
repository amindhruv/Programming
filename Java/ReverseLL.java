import java.util.Scanner;

public class ReverseLL {
    public static void main(String[] args) {
        LinkedList.Node head = new LinkedList.Node(5);
        head.next = new LinkedList.Node(10);
        head.next.next = new LinkedList.Node(15);
        head.next.next.next = new LinkedList.Node(20);
        Scanner sc = new Scanner(System.in);
        boolean recursion = sc.nextBoolean();
        sc.close();
        head = recursion ? reverseWithRecursion(head) : reverse(head);
        print(head);
    }

    private static void print(LinkedList.Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static LinkedList.Node reverse(LinkedList.Node head) {
        LinkedList.Node current, prev = null, next;
        current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static LinkedList.Node reverseWithRecursion(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList.Node temp = reverseWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}