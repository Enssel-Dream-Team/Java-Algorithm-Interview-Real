package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateArray4_17406 {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][m];
        boolean[] visited = new boolean[k];
        Rotate[] rotates = new Rotate[k];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            rotates[i] = new Rotate(
                Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()));
        }
        int result = simulation(map, rotates, visited);
        System.out.println(result);

    }

    private static int simulation(int[][] map, Rotate[] rotates, boolean[] visited) {
        Rotate[] sequence = new Rotate[rotates.length];
        return makeSequence(map, sequence, rotates, 0, rotates.length, visited);

    }

    private static int makeSequence(int[][] map, Rotate[] sequence, Rotate[] rotates, int currentDepth, int maxDepth,
        boolean[] visited) {
        int temp = Integer.MAX_VALUE;
        if (currentDepth == maxDepth) {
            int[][] rotatedMap = rotation(map, sequence);
            temp = Math.min(temp, getMinRow(rotatedMap));
            return temp;
        }
        for (int i = 0; i < maxDepth; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[currentDepth] = rotates[i];
                temp = Math.min(temp, makeSequence(map, sequence, rotates, currentDepth + 1, maxDepth, visited));
                visited[i] = false;
            }
        }
        return temp;
    }

    private static int getMinRow(int[][] rotatedMap) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < rotatedMap.length; i++) {
            int temp = 0;
            for (int j = 0; j < rotatedMap[i].length; j++) {
                temp += rotatedMap[i][j];
            }
            result = Math.min(result, temp);
        }
        return result;
    }

    private static int[][] rotation(int[][] map, Rotate[] rotates) {
        int[][] copiedMap = deepCopy(map);
        for (Rotate rotate : rotates) {
            Rotate working = new Rotate(rotate.r, rotate.c, rotate.s);
            while (working.canSubRotate()) {
                int[] positions = working.makeSubRotate();
                int startY = positions[0];
                int startX = positions[1];
                int endY = positions[2];
                int endX = positions[3];
                int currentY = startY;
                int currentX = startX;
                int previous = copiedMap[startY + 1][startX];
                for (int i = 0; i < 4; i++) {
                    int[] direction = DIRECTIONS[i];
                    while (currentY + direction[0] <= endY && currentX + direction[1] <= endX
                        && currentY + direction[0] >= startY && currentX + direction[1] >= startX) {
                        int temporary = copiedMap[currentY][currentX];
                        copiedMap[currentY][currentX] = previous;
                        previous = temporary;
                        currentY += direction[0];
                        currentX += direction[1];
                    }
                }
            }
        }
        return copiedMap;
    }

    private static int[][] deepCopy(int[][] map) {
        int[][] copied = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copied[i] = (map[i] == null) ? null : map[i].clone();
        }
        return copied;
    }

    private static class Rotate {
        int r;
        int c;
        int s;
        int startX;
        int startY;
        int endX;
        int endY;

        public Rotate(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
            startY = r - s - 1;
            startX = c - s - 1;
            endY = r + s - 1;
            endX = c + s - 1;
        }

        public boolean canSubRotate() {
            return startY != endY && startX != endX;
        }

        public int[] makeSubRotate() {
            return new int[] {startY++, startX++, endY--, endX--};
        }
    }
}
