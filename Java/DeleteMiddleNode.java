public class DeleteMiddleNode {
    public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		printList(head);
		ListNode modified = deleteMiddleNode(head);
		printList(modified);
	}

	private static ListNode deleteMiddleNode(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		return head;
	}
	
	private static void printList(ListNode head) {
	    while (head != null) {
		    System.out.print(head.value + " ");
		    head = head.next;
		}
		System.out.println();
	}

	static class ListNode {
		int value;
		ListNode next;
		ListNode(int value) { this.value = value; }
		ListNode(int value, ListNode next) { this.value = value; this.next = next; }
	}
}
