package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DragonCurve_15685 {
    private static final int[][] directions = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int n;
    private static int[][] map;
    private static Dragon[] dragons;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        map = new int[101][101];
        dragons = new Dragon[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            dragons[i] = new Dragon(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        for (Dragon dragon : dragons) {
            int[] curves = makeCurve(dragon.d, dragon.g);
            makeDragon(dragon.y, dragon.x, curves);
        }
        return findRectangle();
    }

    private static int findRectangle() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
                    count++;
            }
        }
        return count;
    }

    private static void makeDragon(int y, int x, int[] curves) {
        map[y][x] = 1;
        for (int curve : curves) {
            int nextY = y + directions[curve][0];
            int nextX = x + directions[curve][1];
            map[nextY][nextX] = 1;
            y = nextY;
            x = nextX;
        }
    }

    private static int[] makeCurve(int direct, int generation) {
        int[] curves = new int[(int)Math.pow(2, generation)];
        curves[0] = direct;
        if (generation == 0)
            return curves;
        curves[1] = (direct + 1) % 4;
        for (int i = 2; i <= generation; i++) {
            int lastIndex = (int)Math.pow(2, i - 1);
            int[] turning = turningCurve(reverseCurve(lastIndex, curves));
            System.arraycopy(turning, 0, curves, lastIndex, lastIndex);
        }
        return curves;
    }

    private static int[] turningCurve(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (temp[i] + 1) % 4;
        }
        return temp;
    }

    private static int[] reverseCurve(int lastIndex, int[] curves) {
        int[] temp = new int[lastIndex];
        for (int idx = lastIndex - 1; idx >= 0; idx--) {
            temp[lastIndex - idx - 1] = curves[idx];
        }
        return temp;
    }

    private static class Dragon {
        int y;
        int x;
        int d;
        int g;

        public Dragon(int x, int y, int directions, int g) {
            this.y = y;
            this.x = x;
            this.d = directions;
            this.g = g;
        }
    }
}
