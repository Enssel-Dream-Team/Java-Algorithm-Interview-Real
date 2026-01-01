package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IHateOverlapping_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] numberCount = new int[100001];
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] inputs = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = getSizeOfLongSubSeq(n, k, inputs, numberCount);
        System.out.println(result);
    }

    private static int getSizeOfLongSubSeq(int n, int k, int[] inputs, int[] numberCount) {
        int start = 0;
        int end = 0;
        numberCount[inputs[start]]++;
        int maxSubSeqSize = 1;
        while (start < n) {
            if (end + 1 < n && numberCount[inputs[end + 1]] < k) {
                numberCount[inputs[++end]]++;
                maxSubSeqSize = Math.max(maxSubSeqSize, end - start + 1);
            } else {
                numberCount[inputs[start++]]--;
            }
        }
        return maxSubSeqSize;
    }
}
