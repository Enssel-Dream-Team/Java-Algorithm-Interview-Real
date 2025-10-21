package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class largestIncreasingSubsequence_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] inputArray = parseInput(reader.readLine().split(" "));
        long[] dp = new long[n + 1];
        dp[1] = inputArray[1];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = inputArray[i];
            for (int j = 1; j < i; j++) {
                if (inputArray[j] < inputArray[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + inputArray[i]);
                }

            }
        }
        long result = 0;
        for (int i = 1; i < n + 1; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }

    private static int[] parseInput(String[] inputs) {
        int[] result = new int[inputs.length + 1];
        for (int i = 1; i < inputs.length + 1; i++) {
            result[i] = Integer.parseInt(inputs[i - 1]);
        }
        return result;
    }
}
