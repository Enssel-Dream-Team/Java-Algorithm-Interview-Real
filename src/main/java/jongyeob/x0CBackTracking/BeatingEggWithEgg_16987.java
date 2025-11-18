package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeatingEggWithEgg_16987 {
    private static int N;
    private static int result = 0;
    private static int[][] eggsInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        eggsInfo = new int[N][2];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            eggsInfo[i][0] = Integer.parseInt(tokenizer.nextToken());
            eggsInfo[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        backtracking(0);
        System.out.println(result);

    }

    private static void backtracking(int start) {
        if (start == N) {
            int count = 0;
            for (int[] info : eggsInfo) {
                if (info[0] <= 0)
                    count++;
            }
            result = Math.max(result, count);
            return;
        }
        if (eggsInfo[start][0] <= 0) {
            backtracking(start + 1);
            return;
        }
        boolean hit = false;
        if (eggsInfo[start][0] > 0) {
            for (int i = 0; i < N; i++) {
                if (i == start)
                    continue;
                if (eggsInfo[i][0] <= 0 || eggsInfo[start][0] <= 0)
                    continue;
                hit = true;
                eggsInfo[start][0] -= eggsInfo[i][1];
                eggsInfo[i][0] -= eggsInfo[start][1];
                backtracking(start + 1);
                eggsInfo[start][0] += eggsInfo[i][1];
                eggsInfo[i][0] += eggsInfo[start][1];
            }
            if (!hit) {
                backtracking(start + 1);
            }
        }
    }
}