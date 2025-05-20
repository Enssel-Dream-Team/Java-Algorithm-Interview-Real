package jongyeob.stackqueue;

import java.util.Stack;

public class LeetCode_316_RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		boolean[] visited = new boolean[26];

		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			count[idx]--;

			if (visited[idx])
				continue;

			while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
				char removed = stack.pop();
				visited[removed - 'a'] = false;
			}

			stack.push(c);
			visited[idx] = true;
		}

		StringBuilder result = new StringBuilder();
		for (char c : stack) {
			result.append(c);
		}

		return result.toString();
	}
}
