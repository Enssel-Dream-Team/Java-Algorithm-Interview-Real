package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RelativeComplement_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(b);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int target : a) {
            boolean isRelativeComplement = binarySearch(b, target);
            if (isRelativeComplement)
                pq.add(target);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(pq.size()).append('\n');
        while (!pq.isEmpty()) {
            builder.append(pq.poll()).append(" ");
        }
        System.out.println(builder);
    }

    private static boolean binarySearch(int[] b, int target) {
        int start = 0;
        int end = b.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int currentValue = b[mid];
            if (currentValue == target) {
                return false;
            } else if (currentValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return true;
    }
}
