package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciFunction_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int[][] dp = new int[41][2];
        dp[0] = new int[] {1, 0};
        dp[1] = new int[] {0, 1};
        for (int i = 2; i < 41; i++) {
            dp[i] = new int[] {dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]};
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
