package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12100 {

    static int N;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Board board = new Board(map);
        recursion(board, 0);
        System.out.println(ans);
        br.close();
    }

    static void recursion(Board board, int cnt) {
        if (cnt == 5) {
            ans = Math.max(ans, board.getMaxVal());
        } else {
            Board b1 = board.copy();
            Board b2 = board.copy();
            Board b3 = board.copy();
            Board b4 = board.copy();
            b1.moveLeft();
            b2.moveRight();
            b3.moveTop();
            b4.moveBottom();
            recursion(b1, cnt + 1);
            recursion(b2, cnt + 1);
            recursion(b3, cnt + 1);
            recursion(b4, cnt + 1);
        }
    }

    static class Board {
        int[][] map;

        Board(int[][] map) {
            this.map = map;
        }

        public int getMaxVal() {
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, map[i][j]);
                }
            }
            return result;
        }

        public void moveLeft() {
            for (int i = 0; i < N; i++) {
                int idx = 0;
                for (int j = 0; j < N - 1; j++) {
                    if (map[i][j] == 0) {
                        continue;
                    }

                    boolean flag = true;
                    for (int k = j + 1; k < N; k++) {
                        if (map[i][k] == 0) {
                            continue;
                        }

                        int num = map[i][j];
                        if (map[i][j] == map[i][k]) {
                            map[i][k] = 0;
                            num *= 2;
                        }
                        map[i][j] = 0;
                        map[i][idx++] = num;
                        flag = false;
                        break;
                    }
                    if (flag) {
                        int num = map[i][j];
                        map[i][j] = 0;
                        map[i][idx++] = num;
                    }
                }
                if (map[i][N - 1] != 0) {
                    int num = map[i][N - 1];
                    map[i][N - 1] = 0;
                    map[i][idx] = num;
                }
            }
        }

        public void moveRight() {
            for (int i = 0; i < N; i++) {
                int idx = N - 1;
                for (int j = N - 1; j >= 1; j--) {
                    if (map[i][j] == 0) {
                        continue;
                    }

                    boolean flag = true;
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[i][k] == 0) {
                            continue;
                        }

                        int num = map[i][j];
                        if (map[i][j] == map[i][k]) {
                            map[i][k] = 0;
                            num *= 2;
                        }
                        map[i][j] = 0;
                        map[i][idx--] = num;
                        flag = false;
                        break;
                    }
                    if (flag) {
                        int num = map[i][j];
                        map[i][j] = 0;
                        map[i][idx--] = num;
                    }
                }
                if (map[i][0] != 0) {
                    int num = map[i][0];
                    map[i][0] = 0;
                    map[i][idx] = num;
                }
            }
        }

        public void moveTop() {
            for (int i = 0; i < N; i++) {
                int idx = 0;
                for (int j = 0; j < N - 1; j++) {
                    if (map[j][i] == 0) {
                        continue;
                    }

                    boolean flag = true;
                    for (int k = j + 1; k < N; k++) {
                        if (map[k][i] == 0) {
                            continue;
                        }

                        int num = map[j][i];
                        if (map[j][i] == map[k][i]) {
                            map[k][i] = 0;
                            num *= 2;
                        }
                        map[j][i] = 0;
                        map[idx++][i] = num;
                        flag = false;
                        break;
                    }
                    if (flag) {
                        int num = map[j][i];
                        map[j][i] = 0;
                        map[idx++][i] = num;
                    }
                }
                if (map[N - 1][i] != 0) {
                    int num = map[N - 1][i];
                    map[N - 1][i] = 0;
                    map[idx][i] = num;
                }
            }
        }

        public void moveBottom() {
            for (int i = 0; i < N; i++) {
                int idx = N - 1;
                for (int j = N - 1; j >= 1; j--) {
                    if (map[j][i] == 0) {
                        continue;
                    }

                    boolean flag = true;
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] == 0) {
                            continue;
                        }

                        int num = map[j][i];
                        if (map[j][i] == map[k][i]) {
                            map[k][i] = 0;
                            num *= 2;
                        }
                        map[j][i] = 0;
                        map[idx--][i] = num;
                        flag = false;
                        break;
                    }
                    if (flag) {
                        int num = map[j][i];
                        map[j][i] = 0;
                        map[idx][i] = num;
                    }
                }
                if (map[0][i] != 0) {
                    int num = map[0][i];
                    map[0][i] = 0;
                    map[idx][i] = num;
                }
            }
        }

        public Board copy() {
            int[][] copyMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            return new Board(copyMap);
        }
    }
}
