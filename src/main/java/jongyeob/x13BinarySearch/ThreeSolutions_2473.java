package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeSolutions_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] solutions = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(solutions);
        String result = twoPointer(n, solutions);
        System.out.println(result);
    }

    private static String twoPointer(int n, int[] solutions) {
        long minimumGap = Long.MAX_VALUE;
        int resultA = 0;
        int resultB = 0;
        int resultC = 0;
        for (int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                long sum = (long)solutions[i] + solutions[start] + solutions[end];
                if (sum == 0) {
                    resultA = solutions[i];
                    resultB = solutions[start];
                    resultC = solutions[end];
                    break;
                } else if (Math.abs(sum) < minimumGap) {
                    minimumGap = Math.abs(sum);
                    resultA = solutions[i];
                    resultB = solutions[start];
                    resultC = solutions[end];
                }
                if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(resultA).append(" ").append(resultB).append(" ").append(resultC);
        return builder.toString();
    }
}
