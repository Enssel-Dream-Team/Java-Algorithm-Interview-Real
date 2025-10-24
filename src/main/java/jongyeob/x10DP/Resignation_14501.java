package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resignation_14501 {
    public static void main(String[] args) throws IOException {
        int[] workDays = new int[17];
        int[] cost = new int[17];
        long[] dp = new long[17];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfPoint = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= numOfPoint; i++) {
            String[] inputs = reader.readLine().split(" ");
            workDays[i] = Integer.parseInt(inputs[0]);
            cost[i] = Integer.parseInt(inputs[1]);
        }
        for (int i = 1; i < 16; i++) {
            int nextDay = i + workDays[i];
            if (nextDay > 16)
                continue;
            dp[i] = Math.max(dp[i - 1], dp[i]);
            dp[nextDay] = Math.max(dp[i] + cost[i], dp[nextDay]);
        }
        long answer = 0;
        for (int i = 0; i <= numOfPoint + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
