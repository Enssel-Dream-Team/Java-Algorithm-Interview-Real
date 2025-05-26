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
class LinkedListTest extends BaseTest {

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

    @Test
    void Add_Two_Numbers() {
        LeetCode_2_AddTwoNumbers exam = new LeetCode_2_AddTwoNumbers();

        // 1
        ListNode l1 = createListNode(2, 4, 3);
        ListNode l2 = createListNode(5, 6, 4);

        ListNode actual = exam.addTwoNumbers(l1, l2);
        ListNode expected = createListNode(7, 0, 8);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        l1 = createListNode(9, 9, 9, 9, 9, 9, 9);
        l2 = createListNode(9, 9, 9, 9);

        actual = exam.addTwoNumbers(l1, l2);
        expected = createListNode(8, 9, 9, 9, 0, 0, 0, 1);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 3
        l1 = createListNode(0);
        l2 = createListNode(0);

        actual = exam.addTwoNumbers(l1, l2);
        expected = createListNode(0);

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
    void Swap_Nodes_In_Pairs2() {
        LeetCode_24_SwapNodesInPairs exam = new LeetCode_24_SwapNodesInPairs();

        // 1
        ListNode head = createListNode(1, 2, 3, 4);

        ListNode actual = exam.swapPairs2(head);
        ListNode expected = createListNode(2, 1, 4, 3);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 2
        head = createListNode();

        actual = exam.swapPairs2(head);
        expected = createListNode();

        assertArrayEquals(toArray(expected), toArray(actual));

        // 3
        head = createListNode(1);

        actual = exam.swapPairs2(head);
        expected = createListNode(1);

        assertArrayEquals(toArray(expected), toArray(actual));

        // 4
        head = createListNode(1, 2, 3);

        actual = exam.swapPairs2(head);
        expected = createListNode(2, 1, 3);

        assertArrayEquals(toArray(expected), toArray(actual));
    }

    @Test
    void Reverse_Linked_List_2() {
        LeetCode_92_ReverseLinkedList2 exam = new LeetCode_92_ReverseLinkedList2();

        ListNode head = createListNode(1, 2, 3, 4, 5);
        ListNode actual = exam.reverseBetween(head, 2, 4);
        ListNode expected = createListNode(1, 4, 3, 2, 5);

        assertArrayEquals(toArray(expected), toArray(actual));

        head = createListNode(5);
        actual = exam.reverseBetween(head, 1, 1);
        expected = createListNode(5);

        assertArrayEquals(toArray(expected), toArray(actual));
    }
}
