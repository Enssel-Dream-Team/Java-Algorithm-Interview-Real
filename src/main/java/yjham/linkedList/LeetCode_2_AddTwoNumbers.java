package yjham.linkedList;

public class LeetCode_2_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode cur = result;

		int add = 0;

		while (l1 != null || l2 != null || add > 0) {
			int sum = add + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;

			add = sum / 10;

			cur.next = new ListNode(sum % 10);
			cur = cur.next;
		}

		return result.next;
	}
}
