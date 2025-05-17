package sehyuk.linkedList;

public class LeetCode_2_AddTwoNumbers {
	public static void main(String[] args){
		ListNode l1=null,l2=null;
		addTwoNumbers(l1,l2);

	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node= new ListNode(0);
		int carry=0;
		ListNode p = l1, q= l2, curr=node;
		while(p !=null || q!=null){
			int x = (p!=null) ? p.val : 0;
			int y = (q!=null) ? q.val : 0;
			int sum= carry+x+y;
			carry=sum/10;
			curr.next=new ListNode(sum%10);
			curr=curr.next;
			if(p!=null) p= p.next;
			if(q!=null) q=q.next;
		}
		if(carry > 0){
			curr.next= new ListNode(carry);
		}
		return node.next;
	}


}
