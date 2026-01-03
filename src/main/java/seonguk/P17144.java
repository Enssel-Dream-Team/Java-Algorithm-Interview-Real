package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17144 {
    static int R, C;
    static Dust[][] map;
    static Cleaner cleaner;
    static int[][] diffusedMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new Dust[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = new Dust(Integer.parseInt(st.nextToken()));
                if (map[i][j].isCleaner) {
                    if (cleaner == null) {
                        cleaner = new Cleaner(i);
                    }
                }
            }
        }

        while (T-- > 0) {
            diffuseDust();
            doClean();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += map[i][j].getAmount();
            }
        }

        System.out.println(ans);
        br.close();
    }

    static void diffuseDust() {
        diffusedMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j].diffuse(j, i);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j].addDust(diffusedMap[i][j]);
            }
        }
    }

    static void doClean() {
        cleanUp(cleaner.up);
        cleanDown(cleaner.down);
    }

    private static void cleanUp(int y) {
        for (int i = y - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < y; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            map[y][i] = map[y][i - 1];
        }
        map[y][1] = new Dust(0);
    }

    private static void cleanDown(int y) {
        for (int i = y + 2; i < R; i++) {
            map[i - 1][0] = map[i][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > y; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            map[y][i] = map[y][i - 1];
        }
        map[y][1] = new Dust(0);
    }

    static class Cleaner {
        int up;
        int down;

        Cleaner(int y) {
            up = y;
            down = y + 1;
        }
    }

    static class Dust {
        int amount;
        boolean isCleaner;

        public Dust(int amount) {
            if (amount == -1) {
                isCleaner = true;
                return;
            }
            this.amount = amount;
        }

        public void diffuse(int x, int y) {
            int cnt = 0;
            int diffusedDust = amount / 5;

            for (int i = 0; i < 4; i++) {
                int fx = x + dx[i];
                int fy = y + dy[i];
                if (fx >= 0 && fx < C && fy >= 0 && fy < R && !map[fy][fx].isCleaner) {
                    cnt++;
                    diffusedMap[fy][fx] += diffusedDust;
                }
            }
            amount -= cnt * diffusedDust;
        }

        public int getAmount() {
            return amount;
        }

        private void addDust(int addedAmount) {
            amount += addedAmount;
        }
    }
}
