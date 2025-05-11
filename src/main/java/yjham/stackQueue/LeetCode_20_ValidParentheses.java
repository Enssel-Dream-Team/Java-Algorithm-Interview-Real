package yjham.stackQueue;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char close = s.charAt(i);

			if (close == '(' || close == '{' || close == '[') {
				stack.push(close);
			} else {
				if (stack.isEmpty()) return false;

				char open = stack.pop();

				if (open == '(' && close != ')') return false;
				if (open == '{' && close != '}') return false;
				if (open == '[' && close != ']') return false;
			}
		}

		return stack.isEmpty();
	}
}
