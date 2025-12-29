package jongyeob.x14TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConveyorBeltSushi_2531 {
    private static int n;
    private static int d;
    private static int k;
    private static int c;
    private static int[] conveyor;
    private static int[] sushiCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        d = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        conveyor = new int[n];
        sushiCount = new int[d + 1];
        for (int i = 0; i < n; i++) {
            conveyor[i] = Integer.parseInt(reader.readLine());
        }
        int result = twoPoint();
        System.out.println(result);

    }

    private static int twoPoint() {
        int start = 0;
        int end = k - 1;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            int idx = conveyor[i];
            if (sushiCount[idx] == 0) {
                count++;
            }
            sushiCount[idx]++;
        }
        int steps = 0;
        while (steps < n) {
            if (sushiCount[c] == 0) {
                maxCount = Math.max(maxCount, count + 1);
            } else {
                maxCount = Math.max(maxCount, count);
            }

            sushiCount[conveyor[start]]--;
            if (sushiCount[conveyor[start]] == 0) {
                count--;
            }
            start = (start + 1) % n;
            end = (end + 1) % n;
            sushiCount[conveyor[end]]++;
            if (sushiCount[conveyor[end]] == 1) {
                count++;
            }
            steps++;
        }
        return maxCount;
    }
}
