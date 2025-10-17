package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerTriangle_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[height + 1][height + 1];
        long[][] dp = new long[height + 1][height + 1];
        for (int i = 1; i < height + 1; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 1; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }
        for (int i = 1; i < height + 1; i++) {
            dp[i][1] = dp[i - 1][1] + triangle[i][1];
            for (int j = 2; j < i + 1; j++) {
                if (j - 1 > 0)
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                if (j <= i - 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
            }
        }
        long result = 0;
        for (int i = 1; i < height + 1; i++) {
            result = Math.max(result, dp[height][i]);
        }
        System.out.println(result);
    }
}
