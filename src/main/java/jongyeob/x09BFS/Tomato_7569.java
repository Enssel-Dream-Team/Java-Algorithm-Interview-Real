package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_7569 {
    private static int N, M, H;
    private static int[][][] map;
    private static int[][][] visited;
    private static final Queue<Position> queue = new LinkedList<>();
    private static final int[][] direction = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rawInput = reader.readLine().split(" ");
        M = Integer.parseInt(rawInput[0]);
        N = Integer.parseInt(rawInput[1]);
        H = Integer.parseInt(rawInput[2]);
        map = new int[N][M][H];
        visited = new int[N][M][H];

        for (int height = 0; height < H; height++) {
            for (int i = 0; i < N; i++) {
                String[] input = reader.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    int value = Integer.parseInt(input[j]);
                    map[i][j][height] = value;
                    if (value == 1 || value == -1) {
                        if (value == 1)
                            queue.add(new Position(i, j, height));
                        visited[i][j][height] = 0;
                    } else {
                        visited[i][j][height] = -1;
                    }
                }
            }
        }
        int result = solve();
        System.out.println(result);

    }

    private static int solve() {
        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            int x = currentPosition.x;
            int y = currentPosition.y;
            int z = currentPosition.z;
            for (int i = 0; i < 6; i++) {
                int nextX = x + direction[i][0];
                int nextY = y + direction[i][1];
                int nextZ = z + direction[i][2];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H
                    && visited[nextX][nextY][nextZ] == -1) {
                    visited[nextX][nextY][nextZ] = visited[x][y][z] + 1;
                    queue.add(new Position(nextX, nextY, nextZ));
                }
            }
        }
        int highestValue = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int value = visited[i][j][h];
                    if (value == -1)
                        return -1;
                    highestValue = Math.max(highestValue, value);
                }
            }
        }

        return highestValue;
    }

    static class Position {
        int x, y, z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
