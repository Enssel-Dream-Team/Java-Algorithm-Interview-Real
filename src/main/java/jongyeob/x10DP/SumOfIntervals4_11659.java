package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfIntervals4_11659 {

    public static final int MAX_N = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] initNum = reader.readLine().split(" ");
        int N = Integer.parseInt(initNum[0]);
        int M = Integer.parseInt(initNum[1]);
        int[] arr = new int[MAX_N];
        String[] rawArrayInputs = reader.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(rawArrayInputs[i - 1]);
        }
        long[] dp = new long[MAX_N];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        Long[] results = new Long[M];

        for (int i = 0; i < M; i++) {
            String[] inputs = reader.readLine().split(" ");
            int startIndex = Integer.parseInt(inputs[0]);
            int endIndex = Integer.parseInt(inputs[1]);
            long gap = dp[endIndex] - dp[startIndex - 1];
            results[i] = gap;
        }
        for (Long result : results) {
            System.out.println(result);
        }
    }
}
