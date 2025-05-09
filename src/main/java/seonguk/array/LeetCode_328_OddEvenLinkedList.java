package seonguk.array;

import java.util.LinkedList;

public class LeetCode_328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;

        ListNode oddNode = head;
        head = head.next;

        ListNode evenNode;
        if(head != null) {
            evenNode = head;
            head = head.next;
        } else {
            return oddNode;
        }

        ListNode ans = oddNode;
        ListNode remain = evenNode;

        boolean isOdd = true;
        while(head != null) {
            if(isOdd) {
                oddNode.next = head;
                oddNode = oddNode.next;
            } else {
                evenNode.next = head;
                evenNode = evenNode.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        evenNode.next = null;
        oddNode.next = remain;

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
