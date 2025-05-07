package seonguk.array;

public class LeetCode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;

        int tempVal = 0;
        while(l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int result = num1 + num2 + tempVal;
            int val = result % 10;
            tempVal = result / 10;

            temp.next = new ListNode(val);
            temp = temp.next;
        }

        if(tempVal != 0)
            temp.next = new ListNode(tempVal);

        return ans.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
