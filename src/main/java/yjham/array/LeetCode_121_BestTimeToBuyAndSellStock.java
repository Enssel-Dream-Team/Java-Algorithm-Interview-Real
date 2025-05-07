package yjham.array;

public class LeetCode_121_BestTimeToBuyAndSellStock {
    /*
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.
     */

    public int maxProfit(int[] prices) {
        int max = 0;
        int prev = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) {
                max = Math.max(max, prices[i] - prev);
            } else {
                prev = prices[i];
            }
        }

        return max;
    }
}
