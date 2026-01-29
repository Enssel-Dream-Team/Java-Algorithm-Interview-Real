package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingTree_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] tree = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(tokenizer.nextToken());
        }
        long result = getLongestHeight(tree, m);
        System.out.println(result);
    }

    private static long getLongestHeight(int[] tree, int minimumValue) {
        int start = 1;
        int end = 0;
        for (int i : tree) {
            end = Math.max(end, i);
        }
        long answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long slicedLength = sliceTree(tree, mid);
            if (slicedLength >= minimumValue) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static long sliceTree(int[] tree, int mid) {
        long result = 0;
        for (int i : tree) {
            long getTree = i - mid;
            if (getTree > 0)
                result += getTree;
        }
        return result;
    }
}
