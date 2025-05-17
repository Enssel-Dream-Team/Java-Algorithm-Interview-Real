package src.jongyeob;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jongyeob.linkedlist.LeetCode_121_BestTimeToBuyAndSellStock;
import jongyeob.linkedlist.LeetCode_206_ReverseLinkedList;
import jongyeob.linkedlist.LeetCode_21_MergeTwoSortedLists;
import jongyeob.linkedlist.LeetCode_2_AddTwoNumbers;
import jongyeob.linkedlist.LeetCode_92_ReverseLinkedList2;
import jongyeob.linkedlist.ListNode;

public class LinkedListTest {

	@Test
	void LinkedList_Test() {
		LeetCode_121_BestTimeToBuyAndSellStock exam = new LeetCode_121_BestTimeToBuyAndSellStock();
		assertEquals(5, exam.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
		assertEquals(0, exam.maxProfit(new int[] {7, 6, 4, 3, 1}));
		assertEquals(1, exam.maxProfit(new int[] {1, 2}));
	}

	@Test
	public void ReverseLinkedList_Test() throws Exception {
		//given
		LeetCode_206_ReverseLinkedList exam = new LeetCode_206_ReverseLinkedList();
		ListNode actual = exam.reverseList(createListNode(1, 2, 3, 4, 5));
		ListNode expected = createListNode(5, 4, 3, 2, 1);
		assertArrayEquals(toArray(expected), toArray(actual));
	}

	@Test
	public void MergeTwoSortedLists_Test() throws Exception {
		//given
		LeetCode_21_MergeTwoSortedLists exam = new LeetCode_21_MergeTwoSortedLists();
		ListNode actual = exam.mergeTwoLists(createListNode(1, 2, 4), createListNode(1, 3, 4));
		ListNode expected = createListNode(1, 1, 2, 3, 4, 4);
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

	@Test
	public void AddTwoNumbers_Test() throws Exception {
		LeetCode_2_AddTwoNumbers exam = new LeetCode_2_AddTwoNumbers();
		ListNode actual = exam.addTwoNumbers(createListNode(2, 4, 3), createListNode(5, 6, 4));
		ListNode expected = createListNode(7, 0, 8);
		assertArrayEquals(toArray(expected), toArray(actual));

		actual = exam.addTwoNumbers(createListNode(9), createListNode(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));
		expected = createListNode(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
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
