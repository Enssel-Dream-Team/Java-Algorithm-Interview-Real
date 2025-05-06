/**
 *  121. Best Time to Buy and Sell Stock
 *  Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *  explanation :
 *  1. 배열을 순회하면서 최저값을 계속 갱신한다.
 *  2. 최저값이 갱신되지 않으면 이익을 구하고 이익의 최댓값을 구한다.
 *
 **/

public class LeetCode_121_BestTimeToBuyAndSellStock {
	public static void main(String[] args){
		int[] arr={1,2,3,4};
		maxProfit(arr);
	}
  public static int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < min){
                min=prices[i];
                continue;
            }
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }
	
}
