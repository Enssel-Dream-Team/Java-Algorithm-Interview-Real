package yjham.linkedList;

public class LeetCode_2_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		int maxLen = Math.max(len1, len2);

		int[] arr1 = new int[maxLen];
		int[] arr2 = new int[maxLen];

		reverse(l1, arr1);
		reverse(l2, arr2);

		return addTwoArray(maxLen, arr1, arr2);
	}

	private static int length(ListNode head) {
		int len = 0;

		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
	}

	private static void reverse(ListNode head, int[] arr) {
		int idx = arr.length - 1;

		while (head != null) {
			arr[idx--] = head.val;
			head = head.next;
		}
	}

	private static ListNode addTwoArray(int maxLen, int[] arr1, int[] arr2) {
		ListNode result = new ListNode();
		ListNode cur = result;

		int carry = 0;

		while (maxLen-- > 0) {
			int sum = arr1[maxLen] + arr2[maxLen] + carry;

			carry = sum / 10;
			sum = sum % 10;

			cur.next = new ListNode(sum);
			cur = cur.next;
		}

		if (carry > 0) {
			cur.next = new ListNode(carry);
		}

		return result.next;
	}
}
