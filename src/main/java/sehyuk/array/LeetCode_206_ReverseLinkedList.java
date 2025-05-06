package sehyuk.array;
/**
 *  206. Reverse Linked List
 *  Link : https://leetcode.com/problems/reverse-linked-list/description/
 *  explanation : 
 */
public class LeetCode_206_ReverseLinkedList.java{
  	public static void main(String[] args){
  		ListNode head = new ListNode(5);
  		isPalindrome(head);
  	}
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
