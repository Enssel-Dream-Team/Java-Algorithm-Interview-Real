package hyeongil.linkedlist;

public class LeetCode_328_OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		// 짝수 번째 노드를 이루고 있는 노드, 홀수 번째 노드를 이루고 있는 노드
		if (head == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenP = even;

		while (evenP != null && evenP.next != null) {
			odd.next = evenP.next;
			evenP.next = evenP.next.next;

			evenP = evenP.next;
			odd = odd.next;
		}

		odd.next = even;
		return head;
	}
}
