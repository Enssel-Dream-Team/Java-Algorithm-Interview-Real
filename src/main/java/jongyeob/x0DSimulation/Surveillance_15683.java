package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Surveillance_15683 {
    static final int[][][] CCTV_INFO = new int[][][] {
        {},
        {{0}, {1}, {2}, {3}}, // 1번
        {{0, 2}, {1, 3}}, // 2번
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
        {{0, 1, 2, 3}} // 5번
    };
    private static final int[] DY = {0, -1, 0, 1};
    private static final int[] DX = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        List<CCTV> cctvPositions = new ArrayList<>();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value > 0 && value < 6)
                    cctvPositions.add(new CCTV(i, j, value));
                map[i][j] = value;
            }
        }
        int result = dfs(map, cctvPositions, n, m, 0);

        System.out.println(result);
    }

    private static int dfs(int[][] map, List<CCTV> cctvPositions, int n, int m, int depth) {
        if (depth == cctvPositions.size()) {
            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        zeroCount++;
                    }
                }

            }
            return zeroCount;
        }
        int result = Integer.MAX_VALUE;
        CCTV current = cctvPositions.get(depth);
        for (int i = 0; i < CCTV_INFO[current.type].length; i++) {
            int[][] copied = copyMap(map);
            paintArea(copied, n, m, current.y, current.x, current.type, i);
            result = Math.min(result, dfs(copied, cctvPositions, n, m, depth + 1));
        }

        return result;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copiedMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return copiedMap;
    }

    private static void paintArea(int[][] map, int n, int m, int y, int x, int value, int selectedDirection) {
        int[] direction = CCTV_INFO[value][selectedDirection];
        for (int d : direction) {
            int ny = y + DY[d];
            int nx = x + DX[d];
            while (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 6) {
                if (map[ny][nx] == 0)
                    map[ny][nx] = -1;
                ny += DY[d];
                nx += DX[d];
            }
        }
    }

    private static class CCTV {
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}
