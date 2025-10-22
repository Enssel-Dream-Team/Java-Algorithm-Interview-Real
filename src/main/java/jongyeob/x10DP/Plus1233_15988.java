package jongyeob.x10DP;

import java.util.Scanner;

public class Plus1233_15988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] indexs = new int[T];
        for (int i = 0; i < T; i++)
            indexs[i] = scanner.nextInt();
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
        for (int i : indexs) {
            System.out.println(dp[i]);
        }
    }
}
