package jongyeob.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_234_PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		Deque<Integer> deque = new LinkedList<>();
		ListNode now = head;
		while(now != null){
			deque.add(now.val);
			now = now.next;
		}
		while(deque.size() > 1){
			int front = deque.pollFirst();
			int end = deque.pollLast();
			if(front != end)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode node4 = new ListNode(1);
		ListNode node3 = new ListNode(2, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		boolean palindrome = isPalindrome(head);
		System.out.println(palindrome);
	}

}
