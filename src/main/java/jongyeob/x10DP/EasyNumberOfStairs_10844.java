package jongyeob.x10DP;

import java.util.Scanner;

public class EasyNumberOfStairs_10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[101][10];
        dp[1] = new long[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 2; i < 101; i++) {
            dp[i] = calculate(dp[i - 1]);
        }
        long result = 0;
        for (long l : dp[n]) {
            result += l;
        }
        System.out.println(result % 1000000000);
    }

    private static long[] calculate(long[] previous) {
        long[] result = new long[11];
        result[0] = previous[1];
        result[9] = previous[8];
        for (int i = 1; i < 9; i++) {
            result[i] = (previous[i - 1] + previous[i + 1]) % 1000000000;
        }
        return result;
    }
}
