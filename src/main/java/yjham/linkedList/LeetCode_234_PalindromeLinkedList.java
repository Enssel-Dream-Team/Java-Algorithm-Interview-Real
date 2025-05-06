package yjham.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new ArrayDeque<>();

        while (head != null) {
            dq.add(head.val);
            head = head.next;
        }


        while (dq.size() > 1) {
            if (dq.pollFirst() != dq.pollLast()) {
                return false;
            }
        }

        return true;
    }
}
