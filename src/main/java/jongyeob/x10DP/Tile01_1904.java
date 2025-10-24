package jongyeob.x10DP;

import java.util.Scanner;

public class Tile01_1904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long[] dp = new long[1000000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < input + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        long result = dp[input] % 15746;
        System.out.println(result);
    }
}
