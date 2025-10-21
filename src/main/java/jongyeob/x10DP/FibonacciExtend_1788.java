package jongyeob.x10DP;

import java.util.Scanner;

public class FibonacciExtend_1788 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int flag = 1;
        long result = 0;
        if (input == 0) {
            flag = 0;
            result = 0;
            System.out.println(flag);
            System.out.println(result);
            return;
        }
        long[] dp = new long[Math.abs(input) + 2];
        dp[1] = 1;
        if (input > 0) {
            for (int i = 2; i < input + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            }
        } else {
            input = Math.abs(input);
            for (int i = 2; i < input + 1; i++) {
                dp[i] = ((dp[i - 1] * -1) + dp[i - 2]) % 1000000000;
            }
        }
        result = dp[input] % 1000000000;
        if (result < 0) {
            result = Math.abs(result);
            flag = -1;
        }
        System.out.println(flag);
        System.out.println(result);
    }
}
