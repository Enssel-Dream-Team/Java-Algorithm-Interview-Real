package hyeongil.linkedlist;

public class LeetCode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 앞의 수부터 차례대로 수를 더해간다.
        // 두 linked List 둘 다 null 일 때까지 진행한다.
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (l1 != null && l2 != null) {
            int addTwoNumber = l1.val + l2.val + carry;
            // 두 수를 더해서, 10이 넘는다면, 올림수가 발생한다.
            carry = addTwoNumber / 10;
            pointer.next = new ListNode(addTwoNumber % 10);
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            l2 = l2.next;
        }

        // 올림수가 남아있다면, 마지막에 올림수를 추가한다.
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        LeetCode_2_AddTwoNumbers leetcode = new LeetCode_2_AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        leetcode.addTwoNumbers(l1, l2);
    }
}
