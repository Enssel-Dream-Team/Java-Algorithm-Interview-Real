package yjham.stackQueue;

import java.util.Stack;

public class LeetCode_316_RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {
		int len = s.length();

		int[] count = new int[26];
		boolean[] isExist = new boolean[26];

		for (int i = 0; i < len; i++) {
			count[s.charAt(i) - 'a']++;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			int idx = c - 'a';

			count[idx]--;

			if (isExist[idx]) continue;

			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
				isExist[stack.pop() - 'a'] = false;
			}

			stack.push(c);
			isExist[idx] = true;
		}

		return stack.stream()
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
			.toString();
	}
}
