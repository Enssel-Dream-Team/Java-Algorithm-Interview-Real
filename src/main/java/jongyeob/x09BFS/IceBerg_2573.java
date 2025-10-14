package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IceBerg_2573 {
    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int N, M;
    private static int[][] map;
    private static final Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[M][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(inputs[j]);
                map[j][i] = value;
                if (value > 0)
                    queue.add(new Position(j, i));
            }
        }
        int result = solve();
        System.out.println(result);
    }

    private static int solve() {
        if (queue.isEmpty()) {
            return 0;
        }
        int age = 0;
        while (true) {
            if (checkAreaSeparated())
                break;
            deice();
            if (queue.isEmpty())
                return 0;
            age++;
        }
        return age;
    }

    private static boolean checkAreaSeparated() {
        if (queue.isEmpty()) {
            return true;
        }
        Queue<Position> searchQueue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        int queueSize = queue.size();
        Position peek = queue.peek();

        searchQueue.add(peek);
        visited[peek.x][peek.y] = true;
        int scannedArea = 1;

        while (!searchQueue.isEmpty()) {
            Position current = searchQueue.poll();
            int x = current.x;
            int y = current.y;
            for (int j = 0; j < 4; j++) {
                int nextX = x + direction[j][0];
                int nextY = y + direction[j][1];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextX][nextY]
                    && map[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true;
                    scannedArea++;
                    searchQueue.add(new Position(nextX, nextY));
                }
            }
        }
        return scannedArea != queueSize;
    }

    private static void deice() {
        int repeats = queue.size();
        int[][] copiedMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
        for (int i = 0; i < repeats; i++) {
            int nearOcean = 0;
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;
            int currentValue = map[x][y];
            for (int j = 0; j < 4; j++) {
                int nextX = x + direction[j][0];
                int nextY = y + direction[j][1];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && copiedMap[nextX][nextY] == 0) {
                    nearOcean++;
                }
            }
            currentValue -= nearOcean;
            if (currentValue > 0) {
                queue.add(current);
                map[x][y] = currentValue;
            } else {
                map[x][y] = 0;
            }
        }
    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
