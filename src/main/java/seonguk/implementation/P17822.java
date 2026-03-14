package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class P17822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                total += num;
            }
        }

        CircularBoard cb = new CircularBoard(board, N, M, total);

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (d == 0) {
                cb.rotateClockwise(x, k);
            } else {
                cb.rotateCounterClockwise(x, k);
            }
        }

        System.out.println(cb.total);
        br.close();
    }

    static class CircularBoard {
        int[][] board;
        int[] idx;
        int N;
        int M;
        int total;
        int cnt;

        public CircularBoard(int[][] board, int N, int M, int total) {
            this.board = board;
            this.N = N;
            this.M = M;
            this.total = total;
            idx = new int[N];
            cnt = N * M;
        }

        public void rotateClockwise(int x, int k) {
            for (int i = x - 1; i < N; i += x) {
                idx[i] = (idx[i] + M - k) % M;
            }
            calcBoard();
        }

        public void rotateCounterClockwise(int x, int k) {
            for (int i = x - 1; i < N; i += x) {
                idx[i] = (idx[i] + k) % M;
            }
            calcBoard();
        }

        private void calcBoard() {
            Set<Point> set = new HashSet<>();
            findEqualVal(set);

            if (!set.isEmpty()) {
                for (Point p : set) {
                    total -= board[p.y][p.x];
                    board[p.y][p.x] = 0;
                    cnt--;
                }
            } else {
                double avg = (double) total / cnt;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (board[i][j] != 0) {
                            if (board[i][j] < avg) {
                                board[i][j]++;
                                total++;
                            } else if (board[i][j] > avg) {
                                board[i][j]--;
                                total--;
                            }
                        }
                    }
                }
            }
        }

        private void findEqualVal(Set<Point> set) {
            for (int i  = 0; i < M; i++) {
                for (int j  = 0; j < N - 1; j++) {
                    int x1 = (idx[j] + i) % M;
                    int x2 = (idx[j + 1] + i) % M;
                    if (board[j][x1] != 0 && board[j][x1] == board[j + 1][x2]) {
                        set.add(new Point(x1, j));
                        set.add(new Point(x2, j + 1));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 0 && board[i][j] == board[i][(j + 1) % M]) {
                        set.add(new Point(j, i));
                        set.add(new Point((j + 1) % M, i));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
