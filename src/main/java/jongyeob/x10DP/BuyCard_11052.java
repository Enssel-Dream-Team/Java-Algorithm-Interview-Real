package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyCard_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] prices = new int[n + 1];
        String[] rawInputs = reader.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            prices[i] = Integer.parseInt(rawInputs[i - 1]);
        }
        long[] dp = new long[10001];
        dp[1] = prices[1];
        dp[2] = Math.max(dp[1] * 2, prices[2]);
        for (int i = 3; i < n + 1; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
