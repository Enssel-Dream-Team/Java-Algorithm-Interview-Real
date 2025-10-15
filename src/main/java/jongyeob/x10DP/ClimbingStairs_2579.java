package jongyeob.x10DP;

import java.util.Scanner;

public class ClimbingStairs_2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stair = new int[n + 2];
        int[] dp = new int[n + 2];
        stair[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            stair[i] = scanner.nextInt();
        }
        dp[1] = stair[1];
        dp[2] = dp[1] + stair[2];
        for (int i = 3; i < n + 1; i++) {
            int currentStairHeight = stair[i];
            dp[i] = Math.max(dp[i - 2] + currentStairHeight, dp[i - 3] + stair[i - 1] + currentStairHeight);
        }
        System.out.println(dp[n]);
    }
}
