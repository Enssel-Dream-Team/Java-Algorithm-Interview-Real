package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSubsequences_1182 {
    private static int[] sequences;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        sequences = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            sequences[i] = Integer.parseInt(tokenizer.nextToken());
        }
        backtracking(0, N, 0, M);
        if (M == 0)
            count--;
        System.out.println(count);
    }

    private static void backtracking(int idx, int n, int currentSum, int targetSum) {
        if (idx == n) {
            if (currentSum == targetSum) {
                count++;
            }
            return;
        }
        backtracking(idx + 1, n, currentSum + sequences[idx], targetSum);
        backtracking(idx + 1, n, currentSum, targetSum);
    }
}
