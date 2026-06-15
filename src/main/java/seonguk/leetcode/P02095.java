package seonguk.leetcode;

public class P02095 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            ListNode cntNode = head;
            int n = 0;
            while(cntNode != null) {
                n++;
                cntNode = cntNode.next;
            }

            if (n == 1) {
                return null;
            }
            ListNode findNode = head;
            for (int i = 0; i < n / 2 - 1; i++) {
                findNode = findNode.next;
            }
            findNode.next = findNode.next.next;

            return head;
        }
    }
}
