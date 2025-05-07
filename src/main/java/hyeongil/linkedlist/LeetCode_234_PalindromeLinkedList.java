package hyeongil.linkedlist;

public class LeetCode_234_PalindromeLinkedList {

    // LinkedList가 팰린드롬인지 확인하기 위해서
    public boolean isPalindrome(ListNode head) {
        // 순환 single 리스트를 형성하고, 두개의 포인터를 가지고 있으면 문제를 해결할 수 있다.
        ListNode newHead = makeNewList(head);
        ListNode reverseList = reverseList(head);
        // dummyNode의 다음 노드는 첫번째 노드, 이전 노드는 마지막 노드가 된다.
        while (reverseList != null) {
            if (newHead.val != reverseList.val) {
                return false;
            }
            reverseList = reverseList.next;
            newHead = newHead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        // head가 null이면 그대로 return
        if (head == null) {
            return null;
        }
        ListNode newHead = makeNewList(head);
        ListNode afterSwap = makeReverseList(head.next, head);
        return afterSwap;
    }

    private ListNode makeNewList(ListNode head) {

        ListNode listNode = new ListNode(head.val);
        ListNode headNode = listNode;
        head = head.next;
        while (head != null) {
            listNode.next = new ListNode(head.val);
            head = head.next;
            listNode = listNode.next;
        }

        return headNode;
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

    public static void main(String[] args) {
        new LeetCode_234_PalindromeLinkedList().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }
}
