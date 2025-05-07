package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import yjham.linkedList.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("8_연결 리스트 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LinkedListTest {

    @Test
    void Palindrome_Linked_List() {
        LeetCode_234_PalindromeLinkedList exam = new LeetCode_234_PalindromeLinkedList();

        // 1
        assertTrue(exam.isPalindrome(createListNode(1, 2, 2, 1)));

        // 2
        assertFalse(exam.isPalindrome(createListNode(2, 1)));
    }

    @Test
    void Merge_Two_Sorted_Lists() {
        LeetCode_21_MergeTwoSortedLists exam = new LeetCode_21_MergeTwoSortedLists();

        // 1
        ListNode actual = exam.mergeTwoLists(createListNode(1, 2, 4), createListNode(1, 3, 4));
        ListNode expected = createListNode(1, 1, 2, 3, 4, 4);
        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        actual = exam.mergeTwoLists(createListNode(), createListNode());
        expected = createListNode();
        assertArrayEquals(toArray(expected), toArray(actual));

        // 3
        actual = exam.mergeTwoLists(createListNode(), createListNode(0));
        expected = createListNode(0);
        assertArrayEquals(toArray(expected), toArray(actual));

        // 4
        actual = exam.mergeTwoLists(createListNode(), createListNode(1, 2, 3));
        expected = createListNode(1, 2, 3);
        assertArrayEquals(toArray(expected), toArray(actual));
    }

    @Test
    void Reverse_Linked_List() {
        LeetCode_206_ReverseLinkedList exam = new LeetCode_206_ReverseLinkedList();

        // 1
        ListNode actual = exam.reverseList(createListNode(1, 2, 3, 4, 5));
        ListNode expected = createListNode(5, 4, 3, 2, 1);
        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        actual = exam.reverseList(createListNode(1, 2));
        expected = createListNode(2, 1);
        assertArrayEquals(toArray(expected), toArray(actual));

        // 3
        actual = exam.reverseList(createListNode(1));
        expected = createListNode(1);
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
