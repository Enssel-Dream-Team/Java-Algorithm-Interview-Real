package hyeongil.linkedlist;

public class LeetCode_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentPorint = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                currentPorint.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                currentPorint.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            currentPorint = currentPorint.next;
        }

        while (list1 != null) {
            currentPorint.next = new ListNode(list1.val);
            list1 = list1.next;
            currentPorint = currentPorint.next;
        }

        while (list2 != null) {
            currentPorint.next = new ListNode(list2.val);
            list2 = list2.next;
            currentPorint = currentPorint.next;
        }

        return dummyNode.next;
    }
}
