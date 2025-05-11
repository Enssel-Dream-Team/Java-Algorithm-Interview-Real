package yjham.linkedList;

public class LeetCode_24_SwapNodesInPairs {

	/*
		각 쌍마다 짝수 번째가 홀수 번째의 앞에 오게 해야 함
		그러면 각 쌍의 헤드는 짝수가 되어야 하니 시작점은 기존 head의 next
		새로운 head의 next는 기존 head
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;

		return newHead;
	}

	public ListNode swapPairs2(ListNode head) {
		ListNode result = new ListNode();
		result.next = head;
		ListNode cur = result;

		while (cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = cur.next.next;

			first.next = second.next;
			second.next = first;
			cur.next = second;

			cur = first;
		}

		return result.next;
	}
}
