package jongyeob.x0DSimulation;

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GoodbyeFineDust_17144 {
    private static final int[][] UPPER_CYCLE_DIRS = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // → ↑ ← ↓
    private static final int[][] LOWER_CYCLE_DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // → ↓ ← ↑
    private static int[][] map;
    private static List<int[]> cleaner = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int t = Integer.parseInt(tokenizer.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < c; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = value;
                if (value == -1) {
                    cleaner.add(new int[] {i, j});
                }
            }
        }
        int result = simulation(r, c, t);
        out.println(result);
    }

    private static int simulation(int r, int c, int t) {
        for (int time = 0; time < t; time++) {
            map = moveFineDust(r, c);
            cleaningRoom(r, c);
        }
        return countFineDust(r, c);
    }

    private static int countFineDust(int r, int c) {
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += map[i][j];
            }
        }
        return result + 2;
    }

    private static void cleaningRoom(int r, int c) {
        int[] upperCleaner = cleaner.get(0);
        int[] lowerCleaner = cleaner.get(1);

        runCleaner(upperCleaner[0], upperCleaner[1], 0, upperCleaner[0], c, UPPER_CYCLE_DIRS);
        runCleaner(lowerCleaner[0], lowerCleaner[1], lowerCleaner[0], r - 1, c, LOWER_CYCLE_DIRS);
    }

    private static void runCleaner(int cleanerR, int cleanerC, int rMin, int rMax, int c,
        int[][] cycleDirs) {
        int previous = 0;
        int currentR = cleanerR;
        int currentC = cleanerC;

        for (int d = 0; d < 4; d++) {
            int directionR = cycleDirs[d][0];
            int directionC = cycleDirs[d][1];

            while (true) {
                int nextR = currentR + directionR;
                int nextC = currentC + directionC;

                if (nextR < rMin || nextR > rMax || nextC < 0 || nextC > c - 1) {
                    break;
                }
                if (map[nextR][nextC] == -1) {
                    break;
                }

                int temp = map[nextR][nextC];
                map[nextR][nextC] = previous;
                previous = temp;

                currentR = nextR;
                currentC = nextC;
            }
        }
    }

    private static int[][] moveFineDust(int r, int c) {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    continue;
                } else if (map[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                int fineDust = map[i][j];
                int moveAmount = fineDust / 5;
                for (int next = 0; next < 4; next++) {
                    int nextR = i + UPPER_CYCLE_DIRS[next][0];
                    int nextC = j + UPPER_CYCLE_DIRS[next][1];
                    if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c && map[nextR][nextC] != -1) {
                        temp[nextR][nextC] += moveAmount;
                        fineDust -= moveAmount;
                    }
                }
                temp[i][j] += fineDust;
            }
        }
        return temp;
    }
}
