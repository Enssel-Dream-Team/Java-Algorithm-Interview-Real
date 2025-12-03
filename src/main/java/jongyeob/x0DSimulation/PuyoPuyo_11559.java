package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PuyoPuyo_11559 {
    private static char[][] map = new char[12][6];
    private static boolean[][] visited;
    private static int chainCount = 0;
    private static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String input = reader.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        simulation();
        System.out.println(chainCount);
    }

    private static void simulation() {
        while (true) {
            downPuyo();
            if (!removePuyo()) {
                break;
            }
        }
    }

    private static boolean removePuyo() {
        boolean isRemoved = false;
        visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || visited[i][j])
                    continue;
                if (scanPuyo(i, j, map[i][j])) {
                    isRemoved = true;
                }
            }
        }
        if (isRemoved)
            chainCount++;
        return isRemoved;
    }

    private static boolean scanPuyo(int y, int x, char color) {
        Queue<Position> queue = new ArrayDeque<>();
        Stack<Position> history = new Stack<>();
        Position initPosition = new Position(y, x);
        visited[y][x] = true;
        queue.add(initPosition);
        history.add(initPosition);
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = current.y + directions[i][0];
                int nextX = current.x + directions[i][1];
                if (nextY >= 0 && nextY < 12 && nextX >= 0 && nextX < 6 && !visited[nextY][nextX]
                    && map[nextY][nextX] == color) {
                    Position nextPosition = new Position(nextY, nextX);
                    visited[nextY][nextX] = true;
                    queue.add(nextPosition);
                    history.add(nextPosition);
                }
            }
        }
        if (history.size() > 3) {
            while (!history.isEmpty()) {
                Position current = history.pop();
                map[current.y][current.x] = '.';
            }
            return true;
        }
        return false;
    }

    private static void downPuyo() {
        for (int i = 11; i > -1; i--) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.')
                    continue;
                int gapFromTop = 0;
                while (true) {
                    int nextHeight = i + gapFromTop - 1;
                    if (nextHeight >= 0) {
                        if (map[nextHeight][j] == '.') {
                            gapFromTop--;
                        } else {
                            gapFromTop--;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (map[i + gapFromTop][j] != '.') {
                    map[i][j] = map[i + gapFromTop][j];
                    map[i + gapFromTop][j] = '.';
                }
            }
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
