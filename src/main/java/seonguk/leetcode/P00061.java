package seonguk.leetcode;

public class P00061 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }

            int size = 1;
            ListNode lastNode = head;
            while (lastNode.next != null) {
                size++;
                lastNode = lastNode.next;
            }

            k %= size;
            if (k == 0) {
                return head;
            }

            k = size - k;

            ListNode result = head;
            while (k-- > 1) {
                result = result.next;
            }

            ListNode newHead = result.next;
            result.next = null;
            lastNode.next = head;

            return newHead;
        }
    }

}
