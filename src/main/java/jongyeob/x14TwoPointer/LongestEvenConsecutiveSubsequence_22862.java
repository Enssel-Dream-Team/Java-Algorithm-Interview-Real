package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestEvenConsecutiveSubsequence_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = slidingWindow(n, k, arr);
        System.out.println(result);
    }

    private static int slidingWindow(int n, int k, int[] arr) {
        int start = 0;
        int end = 0;
        int longestLength = arr[start] % 2 == 0 ? 1 : 0;
        int removed = arr[start] % 2 == 1 ? 1 : 0;
        while (end < n - 1) {
            if (arr[end + 1] % 2 == 0) {
                end++;
                longestLength = Math.max(longestLength, (end - start + 1) - removed);
            } else if (removed < k) {
                end++;
                removed++;
                longestLength = Math.max(longestLength, (end - start + 1) - removed);
            } else {
                while (removed == k) {
                    if (arr[start] % 2 == 1) {
                        removed--;
                    }
                    start++;
                }
            }
        }
        return longestLength;
    }
}
