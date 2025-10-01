package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class KnightsMovement_7562 {
    private static final int[] xDirection = {2, 2, -2, -2, 1, -1, 1, -1};
    private static final int[] yDirection = {1, -1, 1, -1, 2, 2, -2, -2};
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] results = new int[T];
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(reader.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            Position startPosition = new Position(reader.readLine().split(" "));
            Position targetPosition = new Position(reader.readLine().split(" "));
            int result = solve(startPosition, targetPosition);
            results[i] = result;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int solve(Position startPosition, Position targetPosition) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(startPosition);
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.equals(targetPosition)) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = current.x + xDirection[i];
                int nextY = current.y + yDirection[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[current.x][current.y] + 1;
                    queue.add(new Position(nextX, nextY));
                }
            }
        }

        return map[targetPosition.x][targetPosition.y];
    }

    private static class Position {
        int x, y;

        public Position(String[] input) {
            this.x = Integer.parseInt(input[0]);
            this.y = Integer.parseInt(input[1]);
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            Position position = (Position)o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
