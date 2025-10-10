package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Fire_5427 {
    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int W, H;
    private static int[][] visited;
    private static int[][] fireMap;
    private static final int INF = 999999999;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            String[] widthAndHeight = reader.readLine().split(" ");
            W = Integer.parseInt(widthAndHeight[0]);
            H = Integer.parseInt(widthAndHeight[1]);
            List<Position> firePositions = new LinkedList<>();
            fireMap = new int[H][W];
            visited = new int[H][W];
            Position playerPosition = null;

            for (int i = 0; i < H; i++) {
                String input = reader.readLine();
                for (int j = 0; j < W; j++) {
                    char c = input.charAt(j);
                    if (c == '#') {
                        fireMap[i][j] = -1;
                    } else if (c == '@') {
                        playerPosition = new Position(j, i);
                    } else if (c == '*') {
                        firePositions.add(new Position(j, i));
                        fireMap[i][j] = 0;
                    } else {
                        fireMap[i][j] = INF;

                    }
                }
            }

            for (int i = 0; i < H; i++)
                Arrays.fill(visited[i], -1);
            visited[playerPosition.y][playerPosition.x] = 0;

            String result = solve(playerPosition, firePositions);
            System.out.println(result);
        }
    }

    private static String solve(Position playerPosition, List<Position> firePositions) {
        Queue<Position> queue = new LinkedList<>();

        for (Position position : firePositions) {
            queue.add(position);
        }
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;
            for (int d = 0; d < 4; d++) {
                int nextX = x + direction[d][0];
                int nextY = y + direction[d][1];
                if (canMove(nextX, nextY) && fireMap[nextY][nextX] == INF) {
                    fireMap[nextY][nextX] = fireMap[y][x] + 1;
                    queue.add(new Position(nextX, nextY));
                }
            }
        }
        queue.add(playerPosition);
        if (playerPosition.x == 0 || playerPosition.x == W - 1 || playerPosition.y == 0 || playerPosition.y == H - 1) {
            return String.valueOf(1);
        }

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;
            for (int d = 0; d < 4; d++) {
                int nextX = x + direction[d][0];
                int nextY = y + direction[d][1];
                if (canMove(nextX, nextY) && visited[nextY][nextX] == -1) {
                    if (fireMap[nextY][nextX] == -1 || // 벽인 경우
                        visited[y][x] + 1 >= fireMap[nextY][nextX]) // 다음 좌표가 불 전파 시간보다 느릴 경우
                        continue;
                    visited[nextY][nextX] = visited[y][x] + 1;
                    if (nextX == 0 || nextX == W - 1 || nextY == 0 || nextY == H - 1) {
                        return String.valueOf(visited[nextY][nextX] + 1);
                    }
                    queue.add(new Position(nextX, nextY));
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextX < W && nextY >= 0 && nextY < H;
    }

    private static class Position {
        int x, y;

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
