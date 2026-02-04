package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheSumIs0_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] inputs = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(inputs);
        long result = twoPointer(n, inputs);
        System.out.println(result);
    }

    private static long twoPointer(int n, int[] inputs) {
        long count = 0;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = inputs[i] + inputs[start] + inputs[end];
                if (sum == 0) {
                    if (inputs[start] == inputs[end]) {
                        int k = end - start + 1;
                        count += (k * (k - 1)) / 2;
                        break;
                    } else {
                        int startCount = 1;
                        int endCount = 1;
                        while (start + startCount < end && inputs[start] == inputs[start + startCount]) {
                            startCount++;
                        }
                        while (end - endCount > start && inputs[end] == inputs[end - endCount]) {
                            endCount++;
                        }
                        count += (long)startCount * endCount;
                        start += startCount;
                        end -= endCount;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
