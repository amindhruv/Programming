/* Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
If n is greater than the size of the list, return NULL. */

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

ListNode* deleteNthLastNode(ListNode *head, int n) {
	ListNode *first = head, *second = head;
	for (int i = 0; i < n; i++) {
		if (!first) return NULL;
		first = first->next;
	}
	if (!first) return head->next;
	while (first->next) {
		first = first->next;
		second = second->next;
	}
	second->next = second->next->next;
	return head;
}