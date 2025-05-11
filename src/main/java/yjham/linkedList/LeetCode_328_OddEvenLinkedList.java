package yjham.linkedList;

public class LeetCode_328_OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode front = head;
		ListNode back = head.next;
		ListNode backStart = back;

		while (back != null && back.next != null) {
			front.next = back.next;
			front = front.next;

			back.next = front.next;
			back = back.next;
		}

		front.next = backStart;

		return head;
	}
}
