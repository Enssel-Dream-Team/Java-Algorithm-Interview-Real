package yjham.stackQueue;

import java.util.Stack;

public class LeetCode_739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        return answer;
    }
}
