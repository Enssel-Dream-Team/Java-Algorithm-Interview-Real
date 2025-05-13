package jongyeob.linkedlist;

public class LeetCode_92_ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int left, int right){
		if(left == right) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for(int i = 1; i < left; i++){
			pre = pre.next;
		}
		ListNode start = pre.next;
		ListNode end = start.next;
		for(int i = 0; i < right - left; i++){
			start.next = end.next;
			end.next = pre.next;
			pre.next = end;
			end = start.next;
		}
		return dummy.next;
	}
}
