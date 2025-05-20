package hyeongil.linkedlist;

public class LeetCode_92_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		// 1. left - right 까지의 연결리스트를 따로 추출
		ListNode curP = head;
		ListNode beforeP = head;
		for (int i = 0; i < left - 1; i++) {
			beforeP = curP;
			curP = curP.next;
		}

		ListNode subNodeHead = curP;
		ListNode subNodeTail = curP;

		for (int i = 0; i < right - left; i++) {
			subNodeTail = subNodeTail.next;
		}

		ListNode subListNext = subNodeTail.next; // 서브리스트의 다음 부분
		subNodeTail.next = null;

		subNodeHead = reverse(subNodeHead);
		if (curP == beforeP) {
			// 서브리스트 범위에 head가 포함돼있다.
			curP.next = subListNext;
			return subNodeHead;
		}
		beforeP.next = subNodeHead;
		curP.next = subListNext;
		return head;
	}

	private ListNode reverse(ListNode head) {
		ListNode p = head;
		ListNode rev = null;
		while (p != null) {
			ListNode next = p.next;
			p.next = rev;
			rev = p;
			p = next;
		}
		return rev;
	}
}
