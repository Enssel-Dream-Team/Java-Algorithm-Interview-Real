package minsun.array;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode_328_OddEvenLinkedList  {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }

        odd.next = evenHead;

        return head;
    }
}