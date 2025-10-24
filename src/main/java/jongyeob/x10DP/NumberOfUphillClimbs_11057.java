package jongyeob.x10DP;

import java.util.Scanner;

public class NumberOfUphillClimbs_11057 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] dp = new long[N + 1][10];
        dp[1] = new long[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = 1L;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
        long result = 0;
        for (long l : dp[N]) {
            result += l;
        }
        System.out.println(result % 10007);
    }
}
