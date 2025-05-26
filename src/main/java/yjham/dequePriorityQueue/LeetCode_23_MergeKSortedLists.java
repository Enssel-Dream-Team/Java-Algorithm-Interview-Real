package yjham.dequePriorityQueue;

import yjham.linkedList.ListNode;

import java.util.PriorityQueue;

public class LeetCode_23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;

            if (cur.next != null) pq.offer(cur.next);
        }

        return dummy.next;
    }
}
