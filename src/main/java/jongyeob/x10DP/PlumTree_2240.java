package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlumTree_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int[][] plumTrees = new int[t][2];
        int[][] dp = new int[t][w + 1];
        for (int i = 0; i < t; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int tree = Integer.parseInt(tokenizer.nextToken()) - 1;
            plumTrees[i][tree] = 1;
        }
        dp[0][0] = plumTrees[0][0];
        for (int i = 1; i < t; i++) {
            dp[i][0] = dp[i - 1][0] + plumTrees[i][0];
        }

        for (int i = 1; i < w + 1; i++) {
            dp[0][i] = plumTrees[0][i % 2];
            for (int j = 1; j < t; j++) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - 1]) + plumTrees[j][i % 2];
            }
        }
        int result = 0;
        for (int i = 0; i < w + 1; i++) {
            result = Math.max(result, dp[t - 1][i]);
        }
        System.out.println(result);
    }
}
