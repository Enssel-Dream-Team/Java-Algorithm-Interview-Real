package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsecutiveSums_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(reader.readLine());
        String[] rawInputs = reader.readLine().split(" ");
        int[] inputs = new int[inputSize + 1];
        for (int i = 1; i < inputSize + 1; i++) {
            inputs[i] = Integer.parseInt(rawInputs[i - 1]);
        }
        long[] dp = new long[inputSize + 1];
        dp[1] = inputs[1];
        for (int i = 2; i < inputSize + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + inputs[i], inputs[i]);
        }
        long result = Long.MIN_VALUE;
        for (int i = 1; i < inputSize + 1; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
