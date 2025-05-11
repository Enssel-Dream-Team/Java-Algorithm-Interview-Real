package yjham.linkedList;

public class LeetCode_92_ReverseLinkedList2 {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || left == right) return head;

		ListNode prev = new ListNode();
		ListNode cur = head;
		prev.next = cur;

		int move = 0;

		while (++move < right) {
			if (move < left) {
				prev = cur;
				cur = cur.next;
				continue;
			}

			ListNode next = cur.next;
			cur.next = next.next;
			next.next = prev.next;
			prev.next = next;
		}

		return left == 1 ? prev.next : head;
	}
}
