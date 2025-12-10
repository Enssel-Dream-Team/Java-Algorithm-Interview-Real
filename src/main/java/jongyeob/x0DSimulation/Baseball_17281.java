package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baseball_17281 {
    private static int n;
    private static int bestScore = Integer.MIN_VALUE;
    private static int[][] inning;
    private static int[] batters = new int[9];
    private static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        inning = new int[n][9];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 9; j++) {
                inning[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        batters[3] = 0;
        visited[0] = true;
        makeBatters(0);
        System.out.println(bestScore);
    }

    private static void makeBatters(int depth) {
        if (depth == 9) {
            simulation();
            return;
        }
        if (depth == 3) {
            makeBatters(depth + 1);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                batters[depth] = i;
                makeBatters(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void simulation() {
        int result = 0;
        int batterIndex = 0;
        for (int i = 0; i < n; i++) {
            InningResult innIngResult = startInning(i, batterIndex);
            result += innIngResult.score;
            batterIndex = innIngResult.lastBatterIndex;
        }
        bestScore = Math.max(bestScore, result);
    }

    private static InningResult startInning(int inningNumber, int startBatterIndex) {
        int[] currentInning = inning[inningNumber];
        int[] fieldStatus = new int[4];
        int score = 0;
        int outCount = 0;
        while (outCount < 3) {
            int currentMove = currentInning[batters[startBatterIndex]];
            if (currentMove == 0) {
                outCount++;
                startBatterIndex = (startBatterIndex + 1) % 9;
                continue;
            }
            for (int i = 3; i >= 1; i--) {
                if (fieldStatus[i] == 1) {
                    int nextIndex = i + currentMove;
                    if (nextIndex < 4) {
                        fieldStatus[nextIndex] = 1;
                    } else {
                        score++;
                    }
                    fieldStatus[i] = 0;
                }
            }
            if (currentMove == 4)
                score++;
            else
                fieldStatus[currentMove] = 1;
            startBatterIndex = (startBatterIndex + 1) % 9;
        }
        return new InningResult(startBatterIndex, score);
    }

    private static class InningResult {
        int lastBatterIndex;
        int score;

        public InningResult(int lastBatterIndex, int score) {
            this.lastBatterIndex = lastBatterIndex;
            this.score = score;
        }
    }
}
