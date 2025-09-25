package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MazeExploration_2178 {
    static boolean[][] visited;
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {1, -1, 0, 0};
    static int n;
    static int m;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] raw = reader.readLine().split(" ");
        n = Integer.parseInt(raw[0]);
        m = Integer.parseInt(raw[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }
        int result = solve();
        System.out.println(result);
    }

    private static int solve() {
        int result = bfs(0, 0);
        return result;
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startY][startX] = true;
        dist[startY][startX] = 1;
        queue.add(new int[] {startY, startX});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < 4; i++) {
                int newY = y + yDirection[i];
                int newX = x + xDirection[i];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (!visited[newY][newX] && map[newY][newX] == 1 && dist[newY][newX] == -1) {
                        visited[newY][newX] = true;
                        queue.add(new int[] {newY, newX});
                        dist[newY][newX] = dist[y][x] + 1;
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
