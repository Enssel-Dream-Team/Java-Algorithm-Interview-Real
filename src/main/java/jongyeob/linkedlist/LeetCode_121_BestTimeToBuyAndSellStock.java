package jongyeob.linkedlist;

public class LeetCode_121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int[] result = new int[prices.length];
		for(int i = 1; i < prices.length; i++){
			result[i] = prices[i] - prices[0];
			max = Math.max(result[i], max);
		}
		for(int i = 1 ; i < prices.length; i++){
			int gap = prices[i-1] - prices[i];
			for(int j = i+1 ; j < prices.length; j++){
				result[j] = result[j] + gap;
				max = Math.max(result[j], max);
			}
		}

		return max;
	}
}
