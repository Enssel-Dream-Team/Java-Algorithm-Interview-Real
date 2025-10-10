package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheArea_2583 {
    private static int M, N;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rawInput = reader.readLine().split(" ");
        M = Integer.parseInt(rawInput[0]);
        N = Integer.parseInt(rawInput[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        int K = Integer.parseInt(rawInput[2]);
        for (int i = 0; i < K; i++) {
            String[] input = reader.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            int endX = Integer.parseInt(input[2]);
            int endY = Integer.parseInt(input[3]);
            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    map[x][y] = -1;
                    visited[x][y] = true;
                }
            }
        }
        String result = solve();
        System.out.println(result);
    }

    private static String solve() {
        Queue<Position> queue = new LinkedList<>();
        int areas = 0;
        List<Integer> results = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int startX = 0; startX < N; startX++) {
            for (int startY = 0; startY < M; startY++) {
                if (visited[startX][startY])
                    continue;
                queue.add(new Position(startX, startY));
                visited[startX][startY] = true;
                areas++;
                int region = 0;
                while (!queue.isEmpty()) {
                    Position current = queue.poll();
                    region++;
                    for (int i = 0; i < 4; i++) {
                        int nextY = current.y + direction[i][0];
                        int nextX = current.x + direction[i][1];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.add(new Position(nextX, nextY));
                        }
                    }
                }
                results.add(region);
            }
        }
        builder.append(areas + "\n");
        results.sort(Integer::compareTo);
        for (Integer result : results) {
            builder.append(result + " ");
        }

        return builder.toString();
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
