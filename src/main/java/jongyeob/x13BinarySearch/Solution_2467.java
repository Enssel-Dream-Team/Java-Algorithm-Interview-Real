package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] solution = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(tokenizer.nextToken());
        }
        String result = binarySearch(n, solution);
        System.out.println(result);
    }

    private static String binarySearch(int n, int[] solution) {
        int start = 0;
        int end = n - 1;
        int minResult = Integer.MAX_VALUE;
        int resultA = 0;
        int resultB = 0;
        while (start < end) {
            int a = solution[start];
            int b = solution[end];
            int sum = a + b;
            int absoluteSum = Math.abs(sum);
            if (absoluteSum == 0) {
                resultA = a;
                resultB = b;
                break;
            } else if (absoluteSum < minResult) {
                minResult = absoluteSum;
                resultA = a;
                resultB = b;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(resultA + " " + resultB);
        return builder.toString();
    }
}
