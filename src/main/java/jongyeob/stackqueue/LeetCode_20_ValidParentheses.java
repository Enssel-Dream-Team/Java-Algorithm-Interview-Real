package jongyeob.stackqueue;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {
	public boolean isValid(String s) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);
			if (c.equals("(") || c.equals("{") || c.equals("[")) {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			String popped = stack.pop();
			if (popped.equals("(") && !c.equals(")")) {
				return false;
			}
			if (popped.equals("{") && !c.equals("}")) {
				return false;
			}
			if (popped.equals("[") && !c.equals("]")) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
