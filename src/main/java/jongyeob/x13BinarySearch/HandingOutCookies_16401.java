package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HandingOutCookies_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] cookieLengths = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            cookieLengths[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int maximumCookieLength = calculateLength(m, cookieLengths);
        System.out.println(maximumCookieLength);
    }

    private static int calculateLength(int numOfChild, int[] cookieLengths) {
        int start = 1;
        int end = 0;
        for (int len : cookieLengths) {
            end = Math.max(end, len);
        }
        int maximum = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int quotientCount = 0;
            for (int i = 0; i < cookieLengths.length; i++) {
                quotientCount += (cookieLengths[i] / mid);
            }
            if (quotientCount >= numOfChild) {
                start = mid + 1;
                maximum = mid;
            } else {
                end = mid - 1;
            }
        }
        return maximum;
    }
}
