package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SelectNumber_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        int result = twoPoint(n, m, arr);
        System.out.println(result);
    }

    private static int twoPoint(int n, int m, int[] arr) {
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while (start < n && end < n) {
            int current = Math.abs(arr[start] - arr[end]);
            if (current < m) {
                end++;
            } else {
                result = Math.min(result, current);
                start++;
                if (start == end) {
                    end++;
                }
            }

        }
        return result;
    }
}
