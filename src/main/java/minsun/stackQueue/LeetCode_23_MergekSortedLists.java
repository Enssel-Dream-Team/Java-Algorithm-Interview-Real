package minsun.stackQueue;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class LeetCode_23_MergekSortedLists {
    static ListNode dummy;
    public ListNode LeetCode_23_MergekSortedLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node:lists){
            if (node == null) continue;
            pq.offer(node);
        }

        ListNode prev = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            prev.next = cur;
            prev = cur;
            cur = cur.next;
            if (cur != null) pq.offer(cur);
        }

        return dummy.next;
    }
}