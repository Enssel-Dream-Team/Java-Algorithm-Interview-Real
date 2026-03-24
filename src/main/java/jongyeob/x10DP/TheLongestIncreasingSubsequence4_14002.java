package jongyeob.x10DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheLongestIncreasingSubsequence4_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] dp = new int[n];
        int[] inputs = new int[n];
        int[] parent = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(tokenizer.nextToken());
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (inputs[i] > inputs[j] && dp[i] < dp[j] + 1) {
                    parent[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int result = 0;
        int resultIdx = 0;
        for (int i = 0; i < n; i++) {
            if (result < dp[i]) {
                result = dp[i];
                resultIdx = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        while (resultIdx != -1) {
            stack.push(resultIdx);
            resultIdx = parent[resultIdx];
        }
        StringBuilder builder = new StringBuilder();
        builder.append(stack.size()).append('\n');
        while (!stack.isEmpty()) {
            builder.append(inputs[stack.pop()]).append(' ');
        }
        System.out.println(builder);
    }
}
