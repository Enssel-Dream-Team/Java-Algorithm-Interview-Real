package jongyeob.x10DP;

import java.util.Scanner;

public class WavebanSequence_9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i < 101; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < T; i++) {
            int testCase = scanner.nextInt();
            System.out.println(dp[testCase]);
        }
    }
}
