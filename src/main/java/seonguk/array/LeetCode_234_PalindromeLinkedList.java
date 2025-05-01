package seonguk.array;

import java.util.*;

public class LeetCode_234_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int size = 1;
        ListNode node = head;
        while(node.next != null) {
            size++;
            node = node.next;
        }

        node = head;
        for(int i = 0; i < size / 2; i++) {
            stack.add(node.val);
            node = node.next;
        }

        if(size % 2 == 1) {
            node = node.next;
        }

        for(int i = 0; i < size / 2; i++) {
            if(stack.pop() != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
