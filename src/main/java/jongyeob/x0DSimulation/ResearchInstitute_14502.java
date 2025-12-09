package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstitute_14502 {
    private static final ArrayList<Position> virusPosition = new ArrayList<>();
    private static final Position[] directions = new Position[] {
        new Position(-1, 0), new Position(1, 0),
        new Position(0, -1), new Position(0, 1)
    };
    private static int n, m;
    private static int[][] originalMap;
    private static int maxSafeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        originalMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                int currentValue = Integer.parseInt(tokenizer.nextToken());
                originalMap[i][j] = currentValue;
                if (currentValue == 2) {
                    virusPosition.add(new Position(i, j));
                }
            }
        }
        simulation();
        System.out.println(maxSafeArea);
    }

    private static void simulation() {
        makeWall(0);
    }

    private static void makeWall(int placedWallCount) {
        if (placedWallCount == 3) {
            int[][] copiedMap = new int[originalMap.length][];
            for (int i = 0; i < originalMap.length; i++) {
                copiedMap[i] = Arrays.copyOf(originalMap[i], originalMap[i].length);
            }
            virusSpreads(copiedMap);
            countSafeArea(copiedMap);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] != 0) {
                    continue;
                }
                originalMap[i][j] = 1;
                makeWall(placedWallCount + 1);
                originalMap[i][j] = 0;
            }
        }

    }

    private static void countSafeArea(int[][] copiedMap) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copiedMap[i][j] == 0)
                    count++;
            }
        }
        maxSafeArea = Math.max(maxSafeArea, count);
    }

    private static void virusSpreads(int[][] copiedMap) {
        Queue<Position> queue = new ArrayDeque<>();
        for (Position position : virusPosition) {
            queue.add(position);
        }
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (Position direction : directions) {
                int nextX = current.x + direction.x;
                int nextY = current.y + direction.y;
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && copiedMap[nextY][nextX] == 0) {
                    copiedMap[nextY][nextX] = 2;
                    queue.add(new Position(nextY, nextX));
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
