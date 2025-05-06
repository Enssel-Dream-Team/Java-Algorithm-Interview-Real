package sehyuk.linkedList;


/**
 *  206. Reverse Linked List
 *  Link : https://leetcode.com/problems/reverse-linked-list/description/
 *  explanation :
 *
 */
public class LeetCode_206_ReverseLinkedList{
  	public static void main(String[] args){
  		ListNode head = new ListNode(5);
        reverseList(head);
  	}

    public static ListNode reverseList(ListNode head) {
        return createReverseHead(head);
    }
    private static ListNode createReverseHead(ListNode head) {
        ListNode resultHead = null;

        while (head != null) {
            ListNode next = head.next;  // 스냅샷 
            head.next = resultHead;       
            resultHead = head;            
            head = next;               // 스냅샷 복구 
        }

        return resultHead;
    }
	
}
