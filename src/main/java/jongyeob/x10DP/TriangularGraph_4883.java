package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangularGraph_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = 1;
        while (true) {
            String n = reader.readLine();
            if (n.equals("0")) {
                break;
            }
            int parsedN = Integer.parseInt(n);
            long[][] graph = new long[parsedN + 1][3];
            long[][] dp = new long[parsedN + 1][3];
            for (int i = 1; i < parsedN + 1; i++) {
                String[] rawInputs = reader.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(rawInputs[j]);
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[1][1] = graph[1][1];
            dp[1][2] = dp[1][1] + graph[1][2];
            for (int i = 2; i < parsedN + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    int[] directions = new int[] {j - 1, j, j + 1};
                    for (int direction : directions) {
                        if (direction > -1 && direction < 3) {
                            dp[i][j] = Math.min(dp[i - 1][direction] + graph[i][j], dp[i][j]);
                        }
                    }
                }
                dp[i][1] = Math.min(dp[i][0] + graph[i][1], dp[i][1]);
                dp[i][2] = Math.min(dp[i][1] + graph[i][2], dp[i][2]);
            }
            builder.append(t++).append(". ").append(dp[parsedN][1]).append("\n");
        }
        System.out.println(builder);
    }
}
