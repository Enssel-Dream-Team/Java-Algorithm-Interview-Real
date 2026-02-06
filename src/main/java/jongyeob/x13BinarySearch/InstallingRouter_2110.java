package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallingRouter_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int[] homes = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            homes[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(homes);
        int result = binarySearch(n, c, homes);
        System.out.println(result);
    }

    private static int binarySearch(int n, int c, int[] homes) {
        int start = 0;
        int end = homes[n - 1];
        int maximumGap = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int routerCount = canInstall(mid, homes);
            if (routerCount >= c) {
                maximumGap = Math.max(maximumGap, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return maximumGap;
    }

    private static int canInstall(int mid, int[] homes) {
        int current = homes[0] + mid;
        int count = 1;
        for (int i = 1; i < homes.length; i++) {
            if (current <= homes[i]) {
                current = homes[i] + mid;
                count++;
            }

        }
        return count;
    }
}
