public class CircularLL {
    public static void main(String[] args) {
        LinkedList.Node head = new LinkedList.Node(5);
        head.next = new LinkedList.Node(10);
        head.next.next = new LinkedList.Node(15);
        head.next.next.next = new LinkedList.Node(20);
        head.next.next.next.next = head;
        System.out.println(isCircular(head) ? "It's circular" : "It's not circular");
    }

    private static boolean isCircular(LinkedList.Node head) {
        LinkedList.Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}