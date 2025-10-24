package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker_9465 {
    private static int n;
    private static int[][] inputs;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        long[] results = new long[T];
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(reader.readLine());
            inputs = new int[n + 1][3];
            dp = new long[n + 1][3];
            for (int j = 1; j < 3; j++) {
                String[] rawInputs = reader.readLine().split(" ");
                for (int k = 1; k < n + 1; k++) {
                    inputs[k][j] = Integer.parseInt(rawInputs[k - 1]);
                }
            }
            long result = solve();
            results[i] = result;
        }
        for (long result : results) {
            System.out.println(result);

        }
    }

    private static long solve() {
        dp[1][1] = inputs[1][1];
        dp[1][2] = inputs[1][2];
        for (int i = 2; i < n + 1; i++) {
            dp[i][1] = Math.max(dp[i - 1][2] + inputs[i][1], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + inputs[i][2], dp[i - 1][2]);
        }
        long result = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 3; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
