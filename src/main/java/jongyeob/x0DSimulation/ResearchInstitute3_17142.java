package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstitute3_17142 {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int[][] map;
    private static int emptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ArrayList<Virus> viruses = new ArrayList<>();
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int inputValue = Integer.parseInt(tokenizer.nextToken());
                if (inputValue == 2) {
                    map[i][j] = -2;
                    viruses.add(new Virus(i, j, 0));
                } else if (inputValue == 1) {
                    map[i][j] = -3;
                } else {
                    emptySpace++;
                    map[i][j] = -1;
                }
            }
        }
        if (emptySpace == 0) {
            System.out.println(0);
            return;
        }
        int result = simulation(m, viruses);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int simulation(int m, ArrayList<Virus> viruses) {
        boolean[] visited = new boolean[viruses.size()];
        Virus[] virus = new Virus[m];
        return chooseVirus(0, m, viruses, 0, virus, visited);
    }

    private static int chooseVirus(int start, int m, ArrayList<Virus> viruses, int depth, Virus[] selectedVirus,
        boolean[] visited) {
        if (m == depth) {
            return spreadVirus(selectedVirus);
        }
        int minTime = Integer.MAX_VALUE;
        for (int i = start; i < viruses.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedVirus[depth] = viruses.get(i);
                int semiResult = chooseVirus(i + 1, m, viruses, depth + 1, selectedVirus, visited);
                minTime = Math.min(minTime, semiResult);
                visited[i] = false;
            }
        }
        return minTime;
    }

    private static int spreadVirus(Virus[] selectedVirus) {
        int[][] copiedMap = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copiedMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        int spreadArea = 0;
        Queue<Virus> queue = new ArrayDeque<>();
        for (Virus virus : selectedVirus) {
            copiedMap[virus.y][virus.x] = 0;
            queue.add(virus);
        }
        int maxTime = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {

            Virus currentVirus = queue.poll();
            int y = currentVirus.y;
            int x = currentVirus.x;
            int time = currentVirus.time;
            for (int[] direction : DIRECTIONS) {
                int nextY = y + direction[0];
                int nextX = x + direction[1];
                int nextTime = time + 1;
                if (nextY >= 0 && nextY < copiedMap.length && nextX >= 0 && nextX < copiedMap.length) {
                    if (copiedMap[nextY][nextX] == -1) {
                        spreadArea++;
                        copiedMap[nextY][nextX] = nextTime;
                        maxTime = Math.max(maxTime, nextTime);
                        queue.add(new Virus(nextY, nextX, nextTime));
                    } else if (copiedMap[nextY][nextX] == -2) {
                        copiedMap[nextY][nextX] = -3;
                        queue.add(new Virus(nextY, nextX, nextTime));
                    }
                }
            }
        }
        return spreadArea == emptySpace ? maxTime : Integer.MAX_VALUE;
    }

    private static class Virus {
        int y;
        int x;
        int time;

        public Virus(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
