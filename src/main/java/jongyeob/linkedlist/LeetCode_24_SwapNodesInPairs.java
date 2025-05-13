package jongyeob.linkedlist;

public class LeetCode_24_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (prev.next != null && prev.next.next != null) {
			ListNode left = prev.next;
			ListNode mid = left.next;
			ListNode right = mid.next;

			prev.next = mid;
			mid.next = left;
			left.next = right;

			prev = left;
		}
		return dummy.next;
	}
}
