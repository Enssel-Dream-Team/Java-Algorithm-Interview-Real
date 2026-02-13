package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakTheWallAndMove_2206 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                map[i][j] = c - '0';
            }
        }
        int result = simulation(map, n, m);
        System.out.println(result);
    }

    private static int simulation(int[][] map, int n, int m) {
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0, 1, 0));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            if (position.y == n - 1 && position.x == m - 1) {
                return position.distance;
            }
            for (int[] direction : DIRECTIONS) {
                int nextY = position.y + direction[0];
                int nextX = position.x + direction[1];
                if (canScan(n, m, nextX, nextY)) {
                    if (map[nextY][nextX] == 0 && !visited[nextY][nextX][position.broken]) {
                        queue.add(new Position(nextY, nextX, position.distance + 1, position.broken));
                        visited[nextY][nextX][position.broken] = true;
                    } else if (map[nextY][nextX] == 1 && position.broken == 0 && !visited[nextY][nextX][1]) {
                        queue.add(new Position(nextY, nextX, position.distance + 1, 1));
                        visited[nextY][nextX][1] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean canScan(int n, int m, int nextX, int nextY) {
        return nextX >= 0 && nextX < m && nextY >= 0 && nextY < n;
    }

    private static class Position {
        int y;
        int x;
        int distance;
        int broken;

        public Position(int y, int x, int distance, int broken) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.broken = broken;
        }
    }
}
