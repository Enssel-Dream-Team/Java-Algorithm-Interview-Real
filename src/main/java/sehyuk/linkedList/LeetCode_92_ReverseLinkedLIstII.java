package sehyuk.linkedList;

public class LeetCode_92_ReverseLinkedLIstII {
	public static void main(String[] args){

	}
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode tempHead = new ListNode(0);
		tempHead.next = head;

		int idx=1;
		ListNode actionNode = tempHead;
		while(true){
			if(idx != left){
				idx++;
				actionNode = actionNode.next;
			}else{
				ListNode firstNode = actionNode;
				ListNode lastNode = actionNode.next;
				while(idx <= right){
					if(idx == left){
						idx++;
						actionNode = actionNode.next;
						continue;
					}
					ListNode tempNode = actionNode.next;
					actionNode.next = actionNode.next.next;
					tempNode.next = firstNode.next;
					firstNode.next=tempNode;
					idx++;
				}
				break;
			}
		}
		return tempHead.next;
	}
}
