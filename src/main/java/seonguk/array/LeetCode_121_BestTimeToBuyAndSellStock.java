package seonguk.array;

public class LeetCode_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            int nextVal = prices[i];
            if(nextVal > minVal) {
                ans = Math.max(nextVal - minVal, ans);
            } else {
                minVal = nextVal;
            }
        }

        return ans;
    }
}
