package jongyeob.linkedlist;

public class LeetCode_206_ReverseLinkedList {
	public ListNode reverseList(ListNode head){
		if(head == null) return head;
		ListNode prev = null;
		ListNode now = head;
		ListNode next = null;
		while(now != null){
			next = now.next;
			now.next = prev;
			prev = now;
			now = next;
		}
		return prev;
	}
}
