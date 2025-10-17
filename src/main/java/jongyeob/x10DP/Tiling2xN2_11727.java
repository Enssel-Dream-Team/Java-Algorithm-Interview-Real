package jongyeob.x10DP;

import java.util.Scanner;

public class Tiling2xN2_11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n] % 10007);
    }
}
