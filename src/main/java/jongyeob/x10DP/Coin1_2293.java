package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            coins[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = dynamicProgramming(n, k, coins);
        System.out.println(result);
    }

    private static int dynamicProgramming(int n, int k, int[] coins) {
        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j < k + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[k];
    }
}
