package src.jongyeob;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import jongyeob.linkedlist.LeetCode_24_SwapNodesInPairs;
import jongyeob.linkedlist.LeetCode_328_OddEvenLinkedList;
import jongyeob.linkedlist.ListNode;

@DisplayName("8_연결 리스트 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LinkedListTest {


    @Test
    void Swap_Nodes_In_Pairs() {
        LeetCode_24_SwapNodesInPairs exam = new LeetCode_24_SwapNodesInPairs();

        // 1
        ListNode head = createListNode(1, 2, 3, 4);

        ListNode actual = exam.swapPairs(head);
        ListNode expected = createListNode(2, 1, 4, 3);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        head = createListNode();

        actual = exam.swapPairs(head);
        expected = createListNode();

        assertArrayEquals(toArray(expected), toArray(actual));

        // 3
        head = createListNode(1);

        actual = exam.swapPairs(head);
        expected = createListNode(1);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 4
        head = createListNode(1, 2, 3);

        actual = exam.swapPairs(head);
        expected = createListNode(2, 1, 3);

        assertArrayEquals(toArray(expected), toArray(actual));
    }

    @Test
    void Odd_Even_Linked_List() {
        LeetCode_328_OddEvenLinkedList exam = new LeetCode_328_OddEvenLinkedList();

        // 1
        ListNode head = createListNode(1, 2, 3, 4, 5);

        ListNode actual = exam.oddEvenList(head);
        ListNode expected = createListNode(1, 3, 5, 2, 4);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        head = createListNode(2, 1, 3, 5, 6, 4, 7);

        actual = exam.oddEvenList(head);
        expected = createListNode(2, 3, 6, 7, 1, 5, 4);

        assertArrayEquals(toArray(expected), toArray(actual));
    }

    private ListNode createListNode(int... values) {
        ListNode list = new ListNode();
        ListNode cur = list;

        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return list.next;
    }

    private int[] toArray(ListNode node) {
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
