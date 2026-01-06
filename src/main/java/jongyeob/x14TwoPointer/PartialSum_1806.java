package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSum_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = simulation(n, s, arr);
        System.out.println(result);
    }

    private static int simulation(int n, int s, int[] arr) {
        int start = 0;
        int currentSum = 0;
        int shorestLength = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            currentSum += arr[end];
            while (currentSum >= s) {
                shorestLength = Math.min(shorestLength, end - start + 1);
                currentSum -= arr[start++];
            }
        }
        return shorestLength == Integer.MAX_VALUE ? 0 : shorestLength;
    }
}
