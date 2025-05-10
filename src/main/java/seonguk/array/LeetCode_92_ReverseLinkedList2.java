package seonguk.array;

public class LeetCode_92_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ans = head;
        ListNode start = head;

        for(int i = 0; i < left - 1; i++) {
            start = head;
            head = head.next;
        }

        ListNode reverse = head.next;
        head = head.next;
        for(int i = left; i < right; i++) {
            ListNode next = head.next;
            ListNode remain = next.next;
            next.next = reverse;
            head.next = remain;
            head = head.next;
        }

        start.next = reverse;

        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
