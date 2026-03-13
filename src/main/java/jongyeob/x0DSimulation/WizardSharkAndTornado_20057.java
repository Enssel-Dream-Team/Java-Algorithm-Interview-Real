package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WizardSharkAndTornado_20057 {
    private static final int[] dy = new int[] {0, 1, 0, -1};
    private static final int[] dx = new int[] {-1, 0, 1, 0};
    private static final int[] soY = new int[] {-1, 1, -2, 2, -1, 1, -1, 1, 0};
    private static final int[] negativeSoY = new int[] {1, -1, 2, -2, 1, -1, 1, -1, 0};
    private static final int[] soX = new int[] {1, 1, 0, 0, 0, 0, -1, -1, -2};
    private static final int[] negativeSoX = new int[] {-1, -1, 0, 0, 0, 0, 1, 1, 2};
    private static final int[] percent = new int[] {1, 1, 2, 2, 7, 7, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][n];
        long totalSand = 0;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = value;
                totalSand += value;
            }
        }
        long result = simulation(n, map, totalSand);
        System.out.println(result);
    }

    private static long simulation(int n, int[][] map, long totalSand) {
        int y = n / 2;
        int x = n / 2;
        int degree = 0;
        int step = 1;
        int moved = 0;
        for (int i = 0; i < 2 * (n - 1) + 1; i++) {
            int[] nextPos = moveTornado(map, n, y, x, step, degree);
            y = nextPos[0];
            x = nextPos[1];
            degree = (degree + 1) % 4;
            moved++;
            if (moved == 2) {
                step++;
                moved = 0;
            }
        }
        long sand = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sand += map[i][j];
            }
        }
        return totalSand - sand;
    }

    private static int[] moveTornado(int[][] map, int n, int y, int x, int step, int degree) {
        int targetY = y;
        int targetX = x;
        int[] dustY = getRotatedPosY(degree);
        int[] dustX = getRotatedPosX(degree);
        for (int i = 1; i <= step; i++) {
            int ny = y + dy[degree] * i;
            int nx = x + dx[degree] * i;

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue;
            }
            targetY = ny;
            targetX = nx;
            int nextPosSand = map[ny][nx];
            if (nextPosSand == 0)
                continue;
            map[ny][nx] = 0;
            int removedSand = 0;
            for (int j = 0; j < 9; j++) {
                int sand = (int)(nextPosSand * ((double)percent[j] / 100));
                removedSand += sand;
                int tempY = ny + dustY[j];
                int tempX = nx + dustX[j];
                if (tempY >= 0 && tempY < n && tempX >= 0 && tempX < n) {
                    map[tempY][tempX] += sand;
                }
            }
            int alphaY = ny + dy[degree];
            int alphaX = nx + dx[degree];

            if (alphaY >= 0 && alphaY < n && alphaX >= 0 && alphaX < n) {
                map[alphaY][alphaX] += (nextPosSand - removedSand);
            }
        }

        return new int[] {targetY, targetX};
    }

    private static int[] getRotatedPosX(int degree) {
        if (degree == 0) {
            return soX;
        } else if (degree == 1) {
            return soY;
        } else if (degree == 2) {
            return negativeSoX;
        } else {
            return negativeSoY;
        }
    }

    private static int[] getRotatedPosY(int degree) {
        if (degree == 0) {
            return soY;
        } else if (degree == 1) {
            return negativeSoX;
        } else if (degree == 2) {
            return negativeSoY;
        } else {
            return soX;
        }
    }

}

