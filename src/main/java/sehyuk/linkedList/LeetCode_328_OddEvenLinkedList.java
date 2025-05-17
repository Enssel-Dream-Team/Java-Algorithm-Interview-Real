package sehyuk.linkedList;

public class LeetCode_328_OddEvenLinkedList {
	public static void main(){

	}
	public static ListNode oddEvenList(ListNode head) {
		if(head !=null){
			sort(head);
		}
		return head;
	}
	public static void sort(ListNode head){
		ListNode oddNode = head;
		ListNode evenNode = null;
		ListNode evenNodetail = evenNode;
		int n = 1;
		while(head!=null){
			ListNode tempNode = head;
			head = head.next;
			if(n%2 != 0 ){
				oddNode.next=tempNode;
				oddNode = oddNode.next;
			}else{
				if(evenNode==null){
					evenNode=tempNode;
					evenNodetail = evenNode;

				}else{
					evenNodetail.next=tempNode;
					evenNodetail= evenNodetail.next;
				}
				tempNode.next=null;
			}
			n++;

		}
		oddNode.next=evenNode;
	}
}
