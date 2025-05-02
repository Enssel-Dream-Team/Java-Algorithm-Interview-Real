package minsun.array;

import java.util.*;

class LeetCode_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        for (int i=prices.length - 1;i >= 0;i--){
            int cur = prices[i];

            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            if (cur < stack.peek()){
                answer = Math.max(answer, stack.peek() - cur);
            } else {
                stack.push(cur);
            }
        }

        return answer;
    }
}