package minsun.linkedList;

class LeetCode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    private static ListNode dfs(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0) return null;

        int cur = carry;
        if (l1 != null) cur += l1.val;
        if (l2 != null) cur += l2.val;

        if (l1 == null) l1 = new ListNode();

        l1.val = cur % 10;
        l1.next = dfs(l1 == null ? null : l1.next, l2 == null ? null : l2.next, cur / 10);

        return l1;
    }
}