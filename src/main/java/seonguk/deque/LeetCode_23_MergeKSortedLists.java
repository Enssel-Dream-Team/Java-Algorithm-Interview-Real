package seonguk.deque;

import java.util.*;

public class LeetCode_23_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (ListNode list : lists) {
                while(list != null) {
                    pq.add(list.val);
                    list = list.next;
                }
            }

            if(pq.isEmpty())
                return null;

            ListNode list = new ListNode(pq.poll());
            ListNode head = list;

            while(!pq.isEmpty()) {
                list.next = new ListNode(pq.poll());
                list = list.next;
            }

            return head;
        }
    }
}
