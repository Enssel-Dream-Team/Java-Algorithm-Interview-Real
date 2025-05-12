package jongyeob.linkedlist;

public class LeetCode_2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode now = dummy;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0) {
			int sum = carry;
			if(l1 != null) sum += l1.val;
			if(l2 != null) sum += l2.val;
			carry = sum / 10;
			now.next = new ListNode(sum % 10);
			now = now.next;

			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		return dummy.next;
	}
}
