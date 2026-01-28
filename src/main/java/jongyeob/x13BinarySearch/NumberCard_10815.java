package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] haveCard = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            haveCard[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(haveCard);
        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] isTrue = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            isTrue[i] = binarySearch(haveCard, Integer.parseInt(tokenizer.nextToken()));
        }
        StringBuilder builder = new StringBuilder();
        for (int i : isTrue) {
            builder.append(i).append(" ");
        }
        System.out.println(builder);
    }

    private static int binarySearch(int[] haveCard, int target) {
        int start = 0;
        int end = haveCard.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int currentValue = haveCard[mid];
            if (currentValue == target) {
                return 1;
            } else if (currentValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
