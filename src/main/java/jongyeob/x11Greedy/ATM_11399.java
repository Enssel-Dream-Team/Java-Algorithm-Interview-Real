package jongyeob.x11Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        int n = Integer.parseInt(reader.readLine());
        int[] inputs = getDataFromConsole(reader, n);
        long[] dp = new long[n];
        Arrays.sort(inputs);
        dp[0] = inputs[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + inputs[i];
        }
        for (int i = 0; i < n; i++) {
            result += dp[i];
        }
        System.out.println(result);
    }

    private static int[] getDataFromConsole(BufferedReader reader, int n) throws IOException {
        int[] result = new int[n];
        String[] rawInputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(rawInputs[i]);
        }
        return result;
    }
}
