package hyeongil.array;
// stock을 구입할 수 있는 날은 하루, 구매한 stock을 판매할 수 있는 하루를 선택한다.
public class LeetCode_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            int todayStock = prices[i];
            // 이전날까지 주식을 구매할 수 없었던 경우.
            // -> 현재 주식가보다 이전 주식가가 클 경우.
            if (todayStock < prices[minIndex]) {
                minIndex = i;
            } else {
                // 이전 날에 주식을 구매할 수 있는 상황의 경우.
                // 오늘 주식이 이전 날 주식보다 크다면 이를 저장한다.
                maxProfit = Math.max(maxProfit, todayStock - prices[minIndex]);
            }
        }

        return maxProfit;
    }

}
