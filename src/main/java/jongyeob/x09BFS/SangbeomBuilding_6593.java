package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SangbeomBuilding_6593 {
    private static final int[][] direction = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
    private static int L, R, C;
    private static int[][][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] inputs = reader.readLine().split(" ");
            L = Integer.parseInt(inputs[0]);
            R = Integer.parseInt(inputs[1]);
            C = Integer.parseInt(inputs[2]);
            if (L == 0 && R == 0 && C == 0)
                break;
            map = new int[L][R][C];
            visited = new boolean[L][R][C];
            Position startPosition = null;
            Position endPosition = null;
            for (int z = 0; z < L; z++) {
                for (int i = 0; i < R; i++) {
                    String mapLineInfo = reader.readLine();
                    for (int j = 0; j < C; j++) {
                        char c = mapLineInfo.charAt(j);
                        if (c == 'S') {
                            startPosition = new Position(z, i, j);
                        } else if (c == 'E') {
                            endPosition = new Position(z, i, j);
                        } else if (c == '#') {
                            visited[z][i][j] = true;
                        }
                    }
                }
                reader.readLine();
            }
            String result = solve(startPosition, endPosition);
            System.out.println(result);
        }
    }

    private static String solve(Position startPosition, Position endPosition) {
        Queue<Position> que = new LinkedList<>();
        que.add(startPosition);
        while (!que.isEmpty()) {
            Position current = que.poll();
            if (current == endPosition) {
                break;
            }
            for (int i = 0; i < 6; i++) {
                int nextX = current.x + direction[i][0];
                int nextY = current.y + direction[i][1];
                int nextZ = current.z + direction[i][2];
                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && nextZ >= 0 && nextZ < L
                    && !visited[nextZ][nextX][nextY]) {
                    map[nextZ][nextX][nextY] = map[current.z][current.x][current.y] + 1;
                    visited[nextZ][nextX][nextY] = true;
                    que.add(new Position(nextZ, nextX, nextY));
                }
            }
        }
        int result = map[endPosition.z][endPosition.x][endPosition.y];
        if (result == 0)
            return "Trapped!";
        else
            return "Escaped in %d minute(s).".formatted(result);
    }

    static class Position {
        int x, y, z;

        public Position(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            Position position = (Position)o;
            return x == position.x && y == position.y && z == position.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
}
