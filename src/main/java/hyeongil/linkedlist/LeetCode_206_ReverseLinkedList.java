package hyeongil.linkedlist;
public class LeetCode_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // head가 null이면 그대로 return
        if (head == null) {
            return null;
        }
        ListNode afterSwap = makeReverseList(head.next, head);
        return afterSwap;
    }

    public ListNode makeReverseList(ListNode head, ListNode prev) {


        // head가 null 이면, prev를 반환한다.
        if (head == null) {
            return prev;
        }

        // 해당 요소가 마지막 요소라면, head를 반환한다.
        // head가 null이다. 그 이전 노드가 존재하지 않는다.
        if (head.next == null) {
            // 현재 노드 head, 그 이전 노드가 dummy
            prev.next = null;
            head.next = prev;
            return head;
        }
        // 재귀적으로 순회한 이후, 뒤집은 요소들을 연결한 새로운 linked list
        ListNode afterHead = makeReverseList(head.next, head);
        prev.next = null;
        head.next = prev;
        return afterHead;
    }
}
