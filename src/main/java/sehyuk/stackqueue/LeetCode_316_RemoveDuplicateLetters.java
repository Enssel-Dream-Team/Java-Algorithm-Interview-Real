package sehyuk.stackqueue;

import java.util.Stack;

public class LeetCode_316_RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] lastIndex = new int[26];
		boolean[] list = new boolean[26];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (list[ch - 'a']) continue;

			while (!stack.isEmpty() && ch < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
				char removed = stack.pop();
				list[removed - 'a'] = false;
			}

			stack.push(ch);
			list[ch - 'a'] = true;
		}

		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.reverse().toString();
	}
}
