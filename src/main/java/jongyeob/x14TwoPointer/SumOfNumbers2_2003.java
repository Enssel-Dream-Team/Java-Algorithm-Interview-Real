package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumbers2_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] input = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = partialSum(m, input);
        System.out.println(result);
    }

    private static int partialSum(int m, int[] input) {
        int end = 0;
        int start = 0;
        long tempSum = input[start];
        int count = 0;
        while (start < input.length) {
            if (tempSum == m) {
                count++;
            }
            if (tempSum > m || end == input.length - 1) {
                tempSum -= input[start++];
            } else {
                tempSum += input[++end];
            }
        }
        return count;
    }
}
