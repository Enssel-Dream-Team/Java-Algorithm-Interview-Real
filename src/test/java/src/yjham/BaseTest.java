package src.yjham;

import yjham.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    ListNode createListNode(int... values) {
        ListNode list = new ListNode();
        ListNode cur = list;

        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return list.next;
    }

    int[] toArray(ListNode node) {
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
