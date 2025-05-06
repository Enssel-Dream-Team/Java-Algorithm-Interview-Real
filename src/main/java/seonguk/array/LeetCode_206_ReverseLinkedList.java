package seonguk.array;

import java.util.*;

public class LeetCode_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode ans = null;
        if(head != null) {
            stack.add(head.val);
            while (head.next != null) {
                head = head.next;
                stack.add(head.val);
            }

            ans = new ListNode(stack.pop());
            ListNode temp = ans;
            while (!stack.isEmpty()) {
                temp.next = new ListNode(stack.pop());
                temp = temp.next;
            }
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
