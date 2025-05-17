package minsun.stackQueue;

import java.util.*;

class LeetCode_739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i=0;i<temperatures.length;i++){
            int cur = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[1] < cur){
                int prevIdx = stack.pop()[0];
                answer[prevIdx] += i - prevIdx;
            }
            stack.push(new int[]{i, cur});
        }

        return answer;
    }
}