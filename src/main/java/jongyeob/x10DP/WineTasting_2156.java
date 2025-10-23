package jongyeob.x10DP;

import java.util.Scanner;

public class WineTasting_2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] wines = new int[10001];
        long[] dp = new long[10001];
        for (int i = 1; i < N + 1; i++) {
            wines[i] = scanner.nextInt();
        }
        dp[1] = wines[1];
        dp[2] = dp[1] + wines[2];
        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
