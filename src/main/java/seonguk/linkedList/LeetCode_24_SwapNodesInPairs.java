package seonguk.linkedList;

public class LeetCode_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = (head != null && head.next != null) ? head.next : head;

        if(ans == head)
            return ans;

        recursion(head);
        return ans;
    }

    static ListNode recursion(ListNode node) {
        if(node.next != null && node.next.next != null)
            node.next = recursion(node.next.next);
        if(node.next == null)
            return node;
        ListNode node1 = node.next;
        ListNode node2 = node.next.next;
        node.next = node2;
        node1.next = node;
        return node1;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
