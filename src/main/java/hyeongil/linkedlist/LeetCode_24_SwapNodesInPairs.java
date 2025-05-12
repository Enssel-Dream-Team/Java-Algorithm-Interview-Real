package hyeongil.linkedlist;

public class LeetCode_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // 페어의 스왑노드를 위해서 DummyNode를 head로 둔다.
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        dummy.next = head;

        // 페어의 스왑 노드를 수행하기 위해서, 다음과 같은 순서로 진행한다.
        // 1. 현재 노드의 다다음 노드가, 다음 노드가 되고 다음 노드가 다다음 노드된다.

        // 0 -> [1,2,3,4]
        while (pointer.next != null && pointer.next.next != null) {
            ListNode afterSwapNextNode = pointer.next.next.next;
            ListNode nextNode = pointer.next; // 1
            ListNode nextnextNode = pointer.next.next; // 2

            nextNode.next = afterSwapNextNode; // 1 -> 3 -> 4
            nextnextNode.next = nextNode;
            pointer.next = nextnextNode;

            pointer = nextNode;
        }
        //[1,2,3,4]
        return dummy.next;
    }
}
