package minsun.linkedList;

import java.util.Stack;

class LeetCode_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            length++;
        }

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            if (idx < length / 2) {
                stack.push(head.val);
            }

            if (idx >= length / 2 && !(length % 2 == 1 && idx == length / 2)) {
                if (head.val != stack.pop()) return false;
            }

            head = head.next;
            idx++;
        }

        return true;
    }
}