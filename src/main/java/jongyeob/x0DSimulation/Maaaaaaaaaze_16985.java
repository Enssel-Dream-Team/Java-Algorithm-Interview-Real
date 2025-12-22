package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze_16985 {
    private static final int[][][] map = new int[5][5][5];
    private static final int[][] directions = new int[][] {{-1, 0, 0}, {1, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, 1, 0},
        {0, -1, 0}};
    private static final boolean[] visited = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int layer = 0; layer < 5; layer++) {
            for (int i = 0; i < 5; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < 5; j++) {
                    map[layer][i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
        }
        int result = simulation();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int simulation() {
        Layer[] layers = new Layer[5];
        return makeLayerAndTurn(0, layers);
    }

    private static int makeLayerAndTurn(int depth, Layer[] layers) {
        int temp = Integer.MAX_VALUE;
        if (depth == 5) {
            return findShortestDistance(layers);
        }
        for (int i = 0; i < 5; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            for (int degree = 0; degree < 4; degree++) {
                layers[depth] = new Layer(i, degree);
                temp = Math.min(temp, makeLayerAndTurn(depth + 1, layers));
            }
            visited[i] = false;
        }
        return temp;
    }

    private static int findShortestDistance(Layer[] layers) {
        boolean[][][] isScanned = new boolean[5][5][5];
        if (!isOpen(0, 0, 0, layers) || !isOpen(4, 4, 4, layers))
            return Integer.MAX_VALUE;
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0, 0, 0));
        isScanned[0][0][0] = true;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int currentY = current.y;
            int currentX = current.x;
            int currentZ = current.z;
            for (int[] direction : directions) {
                int nextZ = currentZ + direction[0];
                int nextY = currentY + direction[1];
                int nextX = currentX + direction[2];
                if (nextZ >= 0 && nextZ < 5 && nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && isOpen(nextZ,
                    nextY, nextX, layers) && !isScanned[nextZ][nextY][nextX]) {
                    if (nextZ == 4 && nextX == 4 && nextY == 4) {
                        return current.distance + 1;
                    }
                    isScanned[nextZ][nextY][nextX] = true;
                    queue.add(new Position(nextZ, nextY, nextX, current.distance + 1));
                }
            }

        }
        return Integer.MAX_VALUE;
    }

    private static boolean isOpen(int nextZ, int nextY, int nextX, Layer[] layers) {
        Layer layer = layers[nextZ];
        int boardIdx = layer.index;
        int boardRotate = layer.degree;
        int newY = 0;
        int newX = 0;
        switch (boardRotate) {
            case 0:
                newY = nextY;
                newX = nextX;
                break;
            case 1:
                newY = 4 - nextX;
                newX = nextY;
                break;
            case 2:
                newY = 4 - nextY;
                newX = 4 - nextX;
                break;
            case 3:
                newY = nextX;
                newX = 4 - nextY;
                break;
        }
        return map[boardIdx][newY][newX] == 1;
    }

    private static class Layer {
        int index;
        int degree;

        public Layer(int index, int degree) {
            this.index = index;
            this.degree = degree;
        }
    }

    private static class Position {
        int z;
        int y;
        int x;
        int distance;

        public Position(int z, int y, int x, int distance) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
