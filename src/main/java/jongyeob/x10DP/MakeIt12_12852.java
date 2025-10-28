package jongyeob.x10DP;

import java.util.Scanner;

public class MakeIt12_12852 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int N = scanner.nextInt();
        long[] dp = new long[N + 1];
        int[] parents = new int[N + 1];
        dp[1] = 0;
        parents[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            parents[i] = i - 1;
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                parents[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                parents[i] = i / 2;
            }
        }
        long result = dp[N];
        builder.append(result).append("\n");
        int current = N;
        while (true) {
            if (current == 1) {
                builder.append("1");
                break;
            }
            builder.append(current).append(" ");
            current = parents[current];
        }
        System.out.println(builder);

    }
}
