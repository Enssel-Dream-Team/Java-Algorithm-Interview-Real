package yjham.linkedList;

public class LeetCode_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = reversed;
            reversed = cur;

            cur = next;
        }

        return reversed;
    }
}
