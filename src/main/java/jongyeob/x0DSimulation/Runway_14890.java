package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway_14890 {
    private static int N, L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int result = simulation();
        System.out.println(result);

    }

    private static int simulation() {
        int wayCount = 0;
        for (int i = 0; i < N; i++) {
            wayCount += columnRunway(i);
            wayCount += rowRunway(i);
        }
        return wayCount;
    }

    private static int columnRunway(int columnNumber) {
        boolean[] visited = new boolean[N];
        for (int current = 0; current < N - 1; current++) {
            int nextIndex = current + 1;
            if (map[current][columnNumber] != map[nextIndex][columnNumber]) {
                int gap = map[current][columnNumber] - map[nextIndex][columnNumber];
                if (gap == 1 && nextIndex + L - 1 < N) {
                    int nextValue = map[nextIndex][columnNumber];
                    for (int i = nextIndex; i < nextIndex + L; i++) {
                        if (visited[i] || map[i][columnNumber] != nextValue) {
                            return 0;
                        }
                        visited[i] = true;
                    }
                } else if (gap == -1 && current - L + 1 >= 0) {
                    int currentValue = map[current][columnNumber];
                    for (int i = current - L + 1; i <= current; i++) {
                        if (visited[i] || map[i][columnNumber] != currentValue) {
                            return 0;
                        }
                        visited[i] = true;
                    }
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int rowRunway(int rowNumber) {
        boolean[] visited = new boolean[N];
        for (int current = 0; current < N - 1; current++) {
            int nextIndex = current + 1;
            if (map[rowNumber][current] != map[rowNumber][nextIndex]) {
                int gap = map[rowNumber][current] - map[rowNumber][nextIndex];
                if (gap == 1 && nextIndex + L - 1 < N) {
                    int nextValue = map[rowNumber][nextIndex];
                    for (int i = nextIndex; i < nextIndex + L; i++) {
                        if (visited[i] || map[rowNumber][i] != nextValue) {
                            return 0;
                        }
                        visited[i] = true;
                    }
                } else if (gap == -1 && current - L + 1 >= 0) {
                    int currentValue = map[rowNumber][current];
                    for (int i = current - L + 1; i <= current; i++) {
                        if (visited[i] || map[rowNumber][i] != currentValue) {
                            return 0;
                        }
                        visited[i] = true;
                    }
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
}
