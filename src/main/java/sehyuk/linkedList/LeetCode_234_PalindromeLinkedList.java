package sehyuk.linkedList;
/**
 *  234. Palindrome Linked List
 *  Link : https://leetcode.com/problems/palindrome-linked-list/description/
 *  explanation :
 *  1. 중간 바로 이전 지점을 구한다.
 *  2. 중간 지점 이후부터의 노드들을 역으로 배치한 NodeList를 만든다.
 *  3. 비교하면서 확인한다.
 */
public class LeetCode_234_PalindromeLinkedList{
  	public static void main(String[] args){
  		ListNode head = new ListNode(5);
  		isPalindrome(head);
  	}
    public static boolean isPalindrome(ListNode head) {
          ListNode slow = head;
          ListNode fast = head;
          while (fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next;
              if(fast.next !=null){
                  fast = fast.next;
              }
          }
  
          ListNode reverseHead = createReverseHead(slow);
          boolean result = true;
          while(head!=null){
              if(head.val != reverseHead.val){
                  result = false;
                  break;
              }
              head = head.next;
              reverseHead = reverseHead.next;
  
              if(head == slow){
                  break;
              }
          }
          return result;
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
