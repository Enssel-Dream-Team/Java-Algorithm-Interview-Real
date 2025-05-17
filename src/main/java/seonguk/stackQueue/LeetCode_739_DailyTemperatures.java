package seonguk.stackQueue;

import java.util.Stack;

public class LeetCode_739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Temperature> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                Temperature temp = stack.pop();
                ans[temp.idx] = i - temp.idx;
            }
            stack.add(new Temperature(i, temperatures[i]));
        }

        return ans;
    }

    static class Temperature {
        int idx;
        int temperature;

        Temperature(int idx, int temperature) {
            this.idx = idx;
            this.temperature = temperature;
        }
    }
}
