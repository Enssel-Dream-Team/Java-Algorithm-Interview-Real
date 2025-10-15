package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RgbStreet_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] rgbInfo = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];
        
        for (int i = 1; i < n + 1; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgbInfo[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        dp[1] = rgbInfo[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgbInfo[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgbInfo[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgbInfo[i][2];
        }
        int result = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(result);
    }
}
