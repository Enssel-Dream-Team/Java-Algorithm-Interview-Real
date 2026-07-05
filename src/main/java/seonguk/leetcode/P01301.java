package seonguk.leetcode;

import java.util.*;

public class P01301 {
    class Solution {

        static Position[][] map;
        static char[][] b;
        static int[] dx = {-1, 0, -1};
        static int[] dy = {0, -1, -1};

        public int[] pathsWithMaxScore(List<String> board) {
            int n = board.size();
            b = new char[n][n];
            for (int i = 0; i < n; i++) {
                b[i] = board.get(i).toCharArray();
            }

            map = new Position[n][n];
            map[n - 1][n - 1] = new Position(0, 1);
            map[0][0] = new Position(0, 0);
            b[0][0] = '0';

            int num = 2 * (n - 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    int x = n - i + j - 1;
                    int y = num - x;
                    calc(x, y);
                }
                num--;

            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    int x = j;
                    int y = num - j;
                    calc(x, y);
                }
                num--;
            }

            Position p = map[0][0];
            int[] result = {p.cost, p.cnt};
            return result;
        }

        private void calc(int x, int y) {
            if (map[y][x] == null) {
                return;
            }

            for (int k = 0; k < 3; k++) {
                int fx = x + dx[k];
                int fy = y + dy[k];
                if (fx >= 0 && fy >= 0 && b[fy][fx] >= '0' && b[fy][fx] <= '9') {
                    map[fy][fx] = map[y][x].calcNext(map[fy][fx], b[fy][fx] - '0');
                }
            }
        }

        static class Position {
            private int cost;
            private int cnt;

            Position(int cost, int cnt) {
                this.cost = cost;
                this.cnt = cnt;
            }

            public Position calcNext(Position next, int cost) {
                if (next == null) {
                    return new Position(this.cost + cost, this.cnt);
                }

                int newCost = this.cost + cost;
                if (newCost > next.cost) {
                    return new Position(newCost, this.cnt);
                } else if (newCost == next.cost) {
                    next.addCnt(this.cnt);
                    return next;
                }

                return next;
            }

            private void addCnt(int cnt) {
                this.cnt = (this.cnt + cnt) % (1000_000_000 + 7);
            }
        }
    }
}
