package seonguk.leetcode;

import java.util.*;

public class P02130 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public int pairSum(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while(head != null) {
                list.add(head.val);
                head = head.next;
            }

            int n = list.size();
            int ans = 0;
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(ans, list.get(i) + list.get(n - i - 1));
            }
            return ans;
        }
    }
}
