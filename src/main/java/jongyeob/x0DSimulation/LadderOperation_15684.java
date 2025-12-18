package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderOperation_15684 {
    private static int N, M, H;
    private static boolean[][] ladders;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        H = Integer.parseInt(tokenizer.nextToken());
        ladders = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            ladders[a][b] = true;
        }

        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        boolean isSamePosition = ghostLeg();
        if (isSamePosition) {
            return 0;
        }
        for (int time = 1; time < 4; time++) {
            boolean isSuccess = makePipe(0, time);
            if (isSuccess)
                return time;
        }
        return -1;
    }

    private static boolean makePipe(int currentDepth, int maxDepth) {
        if (currentDepth == maxDepth) {
            return ghostLeg();
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (ladders[i][j] || (j - 1 > 0 && ladders[i][j - 1]) || (ladders[i][j + 1])) {
                    continue;
                }
                ladders[i][j] = true;
                boolean tempResult = makePipe(currentDepth + 1, maxDepth);
                if (tempResult) {
                    return true;
                }
                ladders[i][j] = false;
            }
        }
        return false;
    }

    private static boolean ghostLeg() {
        for (int i = 1; i < N; i++) {
            int currentHeight = 1;
            int currentLegIdx = i;
            while (currentHeight < H + 1) {
                if (ladders[currentHeight][currentLegIdx]) {
                    currentLegIdx++;
                } else if (ladders[currentHeight][currentLegIdx - 1]) {
                    currentLegIdx--;
                }
                currentHeight++;
            }
            if (currentLegIdx != i)
                return false;
        }
        return true;
    }
}
