package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicCabbage_1012 {
    private static int[][] map;
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static int[][] poses;
    private static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] results = new int[T];

        for (int i = 0; i < T; i++) {
            int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = inputs[0];
            N = inputs[1];
            int K = inputs[2];
            map = new int[M][N];
            visited = new boolean[M][N];
            poses = new int[K][2];
            for (int j = 0; j < K; j++) {
                int[] pos = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                poses[j] = pos;
                map[pos[0]][pos[1]] = 1;
            }
            int result = solve();
            results[i] = result;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int solve() {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int[] pos : poses) {
            if (visited[pos[0]][pos[1]])
                continue;
            count++;
            queue.add(pos);
            while (!queue.isEmpty()) {
                int[] currentPos = queue.poll();
                int x = currentPos[0];
                int y = currentPos[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + xDirection[i];
                    int nextY = y + yDirection[i];
                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextX][nextY]
                        && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }

        }
        return count;
    }

}
