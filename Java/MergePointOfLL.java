import java.util.HashMap;

public class MergePointOfLL {
    public static void main(String[] args) {
        LinkedList.Node headA = new LinkedList.Node(1);
        headA.next = new LinkedList.Node(2);
        headA.next = new LinkedList.Node(3);
        LinkedList.Node headB = new LinkedList.Node(5);
        headB.next = new LinkedList.Node(9);
        headB.next = headA;
        System.out.println(mergePointWithExtraMemory(headA, headB));
        System.out.println(mergePointWithoutExtraMemory(headA, headB));
    }

    private static int mergePointWithoutExtraMemory(LinkedList.Node headA, LinkedList.Node headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        int difference = lengthA - lengthB;
        if (lengthA < lengthB) {
            LinkedList.Node temp = headA;
            headA = headB;
            headB = temp;
            difference = lengthB - lengthA;
        }
        for (int i = 0; i < difference; i++)
            headA = headA.next;
        while (headB != null) {
            if (headA == headB) return headA.data;
            headA = headA.next;
            headB = headB.next;
        }
        return -1;
    }

    private static int findLength(LinkedList.Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static int mergePointWithExtraMemory(LinkedList.Node headA, LinkedList.Node headB) {
        HashMap<LinkedList.Node, Integer> hm = new HashMap<>();
        while (headA != null) {
            hm.put(headA, headA.data);
            headA = headA.next;
        }
        while (headB != null) {
            if (hm.containsKey(headB)) return headB.data;
            headB = headB.next;
        }
        return -1;
    }
}