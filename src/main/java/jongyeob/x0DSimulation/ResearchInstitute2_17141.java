package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstitute2_17141 {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0},};
    private static int n;
    private static int virusAmount;
    private static int zeroSpace = 0;
    private static List<Position> viruses = new ArrayList<>();
    private static Position[] selectedVirus;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        virusAmount = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][n];

        selectedVirus = new Position[virusAmount];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value == 2) {
                    viruses.add(new Position(i, j, 0));
                    zeroSpace++;
                } else if (value == 1) {
                    map[i][j] = value;
                } else {
                    zeroSpace++;
                }
            }
        }
        boolean[] dfsVisited = new boolean[viruses.size()];
        int result = selectVirus(0, 0, dfsVisited);
        if (result == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);
    }

    private static int selectVirus(int start, int depth, boolean[] dfsVisited) {
        int temp = Integer.MAX_VALUE;
        if (depth == virusAmount) {
            return spreadVirus();
        }
        for (int i = start; i < viruses.size(); i++) {
            selectedVirus[depth] = viruses.get(i);
            temp = Math.min(temp, selectVirus(i + 1, depth + 1, dfsVisited));
        }
        return temp;
    }

    private static int spreadVirus() {
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] mapVisited = new boolean[n][n];
        int maxAge = 0;
        int spreadCount = 0;
        for (int i = 0; i < virusAmount; i++) {
            queue.add(selectedVirus[i]);
            mapVisited[selectedVirus[i].y][selectedVirus[i].x] = true;
        }
        while (!queue.isEmpty()) {
            spreadCount++;
            Position current = queue.poll();
            int y = current.y;
            int x = current.x;
            maxAge = Math.max(maxAge, current.age);
            for (int[] direction : DIRECTIONS) {
                int nextY = y + direction[0];
                int nextX = x + direction[1];
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !mapVisited[nextY][nextX]
                    && map[nextY][nextX] == 0) {
                    mapVisited[nextY][nextX] = true;
                    queue.add(new Position(nextY, nextX, current.age + 1));
                }
            }

        }
        if (spreadCount == zeroSpace)
            return maxAge;
        else
            return Integer.MAX_VALUE;
    }

    private static class Position {
        int x;
        int y;
        int age;

        public Position(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
    }
}
