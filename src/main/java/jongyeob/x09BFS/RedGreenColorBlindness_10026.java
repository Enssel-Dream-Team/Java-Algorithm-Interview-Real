package jongyeob.x09BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenColorBlindness_10026 {
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[] xDirection = {0, 0, -1, 1};
    private static final int[] yDirection = {1, -1, 0, 0};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = reader.readLine().toCharArray();
        }
        visited = new boolean[N][N];
        int normalResult = solveNormal();
        visited = new boolean[N][N];
        int colorBlindeResult = solveColorBlind();
        System.out.println(normalResult + " " + colorBlindeResult);

    }

    private static int solveNormal() {
        Queue<Position> queue = new LinkedList<>();
        int numberOfArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    queue.add(new Position(i, j));
                    numberOfArea++;
                } else
                    continue;
                while (!queue.isEmpty()) {
                    Position current = queue.poll();
                    char currentChar = map[current.x][current.y];
                    for (int k = 0; k < 4; k++) {
                        int nextX = current.x + xDirection[k];
                        int nextY = current.y + yDirection[k];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                            char nextChar = map[nextX][nextY];
                            if (currentChar == nextChar) {
                                queue.add(new Position(nextX, nextY));
                                visited[nextX][nextY] = true;
                            }
                        }
                    }

                }
            }
        }

        return numberOfArea;
    }

    private static int solveColorBlind() {
        Queue<Position> queue = new LinkedList<>();
        int numberOfArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    queue.add(new Position(i, j));
                    numberOfArea++;
                } else
                    continue;
                while (!queue.isEmpty()) {
                    Position current = queue.poll();
                    char currentChar = map[current.x][current.y];
                    for (int k = 0; k < 4; k++) {
                        int nextX = current.x + xDirection[k];
                        int nextY = current.y + yDirection[k];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                            char nextChar = map[nextX][nextY];
                            if (((currentChar == 'R' || currentChar == 'G') && (nextChar == 'R' || nextChar == 'G'))
                                || currentChar == nextChar) {
                                queue.add(new Position(nextX, nextY));
                                visited[nextX][nextY] = true;
                            }
                        }
                    }

                }
            }
        }

        return numberOfArea;
    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
