package sehyuk.linkedList;

public class LeetCode_24_SwapNodesInPairs {
	public static void main(String[] args){

	}
	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next == null){
			return head;
		}
		head = swap(head);

		return head;
	}
	public static ListNode swap(ListNode head){
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode action = newHead;
		boolean isHead = true;
		while(action.next!=null && action.next.next!= null){
			ListNode tempNode = action;
			ListNode newNode = new ListNode(tempNode.next.next.val, tempNode.next);
			action.next.next = action.next.next.next;
			tempNode.next = newNode;
			action = action.next.next;
			if(isHead){
				newHead.next=newNode;
				isHead = false;
			}
		}
		return newHead.next;
	}
}
