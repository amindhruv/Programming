public class SplitMergeList {
	static class ListNode {
		int value;
		ListNode next;
		ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
		ListNode(int value) { this(value, null); }
	}

	private static void split(ListNode given, ListNode[] nodes) {
		nodes[0] = given;
		nodes[1] = given != null ? given.next : null;
		while (given != null) {
			ListNode next = given.next;
			given.next = next != null ? next.next : null;
			given = next;
		}
	}

	private static ListNode merge(ListNode first, ListNode second) {
		ListNode combined = first;
		while (first != null && second != null) {
			ListNode next = first.next;
			first.next = second;
			first = second;
			second = next;
		}
		return combined;
	}

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		printList(head);
		ListNode[] arr = new ListNode[] {new ListNode(0), new ListNode(0)};
		split(head, arr);
		printList(arr[0]);
		printList(arr[1]);
		ListNode merged = merge(arr[0], arr[1]);
		printList(merged);
	}
}