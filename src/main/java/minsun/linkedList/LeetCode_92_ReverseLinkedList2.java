package minsun.linkedList;




class LeetCode_92_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i=0;i<left - 1;i++){
            prev = prev.next;
        }

        ListNode cur = prev.next;

        for (int i=left;i<right;i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        // 왜 dummy.next는 되고 head는 안되는가?
        return head;
    }
}