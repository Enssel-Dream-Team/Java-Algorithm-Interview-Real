package seonguk.linkedList;

import java.util.*;

public class LeetCode_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(list1.val);
        while(list1.next != null) {
            list1 = list1.next;
            que.add(list1.val);
        }

        que.add(list2.val);
        while (list2.next != null) {
            list2 = list2.next;
            que.add(list2.val);
        }

        ListNode ans = new ListNode(que.poll());
        ListNode temp = ans;
        while(!que.isEmpty()) {
            temp.next = new ListNode(que.poll());
            temp = temp.next;
        }

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
