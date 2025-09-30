package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_7576 {
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {1, -1, 0, 0};
    private static int N, M;
    private static int needChange = 0;
    private static int[][] map;
    private static int[][] visited;
    private static final Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int current = Integer.parseInt(line[j]);
                map[i][j] = current;
                if (current == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 0;
                } else if (current == -1) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                    needChange++;
                }
            }
        }
        int result = solve();
        System.out.println(result);
    }

    private static int solve() {
        int[] currentPos = new int[] {0, 0};
        while (!queue.isEmpty()) {
            currentPos = queue.poll();
            int x = currentPos[0];
            int y = currentPos[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + xDirection[i];
                int nextY = y + yDirection[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && visited[nextX][nextY] == -1
                    && map[nextX][nextY] == 0) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = visited[x][y] + 1;
                    needChange--;
                }
            }
        }
        if (needChange != 0)
            return -1;

        return visited[currentPos[0]][currentPos[1]];
    }
}
