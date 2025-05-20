package jongyeob.stackqueue;

import java.util.Stack;

public class LeetCode_739_DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int top = stack.pop();
				answer[top] = i - top;
			}
			stack.push(i);
		}
		return answer;
	}
}
