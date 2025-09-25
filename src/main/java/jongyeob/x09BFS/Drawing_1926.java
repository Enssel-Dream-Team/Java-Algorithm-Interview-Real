package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Drawing_1926 {
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {1, -1, 0, 0};
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = inputs;
        }
        String result = solve();
        System.out.println(result);
    }

    private static String solve() {
        int highestDepth = 0;
        int drawingCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i, j);
                    highestDepth = Math.max(highestDepth, area);
                    drawingCount++;
                }
            }
        }
        return drawingCount + "\n" + highestDepth + "\n";
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startY][startX] = true;
        queue.add(new int[] {startY, startX});

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int newY = y + yDirection[i];
                int newX = x + xDirection[i];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (!visited[newY][newX] && map[newY][newX] == 1) {
                        visited[newY][newX] = true;
                        queue.add(new int[] {newY, newX});
                        area++;
                    }
                }
            }
        }
        return area;
    }
}
