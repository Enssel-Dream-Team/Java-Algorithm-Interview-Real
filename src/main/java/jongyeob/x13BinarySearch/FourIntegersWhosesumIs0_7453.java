package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourIntegersWhosesumIs0_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[][] inputs = new int[4][n + 1];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            inputs[0][i] = Integer.parseInt(tokenizer.nextToken());
            inputs[1][i] = Integer.parseInt(tokenizer.nextToken());
            inputs[2][i] = Integer.parseInt(tokenizer.nextToken());
            inputs[3][i] = Integer.parseInt(tokenizer.nextToken());
        }
        long[] ab = new long[n * n];
        long[] cd = new long[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[index] = (long)inputs[0][i] + inputs[1][j];
                cd[index] = (long)inputs[2][i] + inputs[3][j];
                index++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        long result = 0;
        int start = 0;
        int end = n * n - 1;
        while (start < n * n && end >= 0) {
            long front = ab[start];
            long back = cd[end];
            long sum = front + back;
            if (sum == 0) {
                int sameFront = 0;
                int sameBack = 0;
                while (start < n * n && front == ab[start]) {
                    sameFront++;
                    start++;
                }
                while (end >= 0 && back == cd[end]) {
                    sameBack++;
                    end--;
                }
                result += (long)sameFront * sameBack;
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result);
    }
}
