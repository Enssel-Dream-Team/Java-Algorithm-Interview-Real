package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SafeArea_2468 {
    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        int[][] map = new int[N][N];
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(inputs[j]);
                map[i][j] = now;
                maxValue = Math.max(maxValue, now);
            }
        }
        int result = solve(map, maxValue);
        System.out.println(result);
    }

    private static int solve(int[][] map, int maxValue) {
        boolean[][] visited = new boolean[N][N];
        int maxArea = 0;
        for (int height = 0; height <= maxValue; height++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = map[i][j] <= height;
                }
            }
            int area = calculateSafeAreas(visited);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int calculateSafeAreas(boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        int countArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }
                queue.add(new Position(i, j));
                visited[i][j] = true;
                countArea++;
                while (!queue.isEmpty()) {
                    Position current = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nextX = current.x + direction[d][0];
                        int nextY = current.y + direction[d][1];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.add(new Position(nextX, nextY));
                        }
                    }
                }
            }
        }
        return countArea;
    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
