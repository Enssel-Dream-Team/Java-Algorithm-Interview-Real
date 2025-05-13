package minsun.array;

class LeetCode_24_SwapNodesInPairs  {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        if (head.next != null){
            ListNode nextNode = head.next.next;
            head.next.next = head;
            head = head.next;
            head.next.next = swapPairs(nextNode);
        }

        return head;
    }
}