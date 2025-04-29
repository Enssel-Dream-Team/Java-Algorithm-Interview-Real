package src.yjham.array;

import java.util.Stack;

public class LeetCode_42_TrappingRainWater {

	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;

		int leftMax = -1;
		int rightMax = -1;

		int sum = 0;

		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			sum += leftMax <= rightMax ? leftMax - height[left++] : rightMax - height[right--];
		}

		return sum;
	}

	public int trap2(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int top = stack.pop();

				if (stack.isEmpty()) break;

				int distance = i - stack.peek() - 1;
				int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];

				sum += distance * boundedHeight;
			}

			stack.push(i);
		}

		return sum;
	}
}
