package seonguk.leetcode;

import java.util.*;

public class P03286 {
    class Solution {

        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, 1, 0, -1};

        static boolean ans;
        static List<List<Integer>> grid;
        static int n, m;
        static int[][] visited;

        public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            ans = false;
            this.grid = grid;
            n = grid.size();
            m = grid.get(0).size();
            visited = new int[n][m];
            health -= grid.get(0).get(0);
            visited[0][0] = health;
            dfs(0, 0, health);

            return ans;
        }

        static void dfs(int x, int y, int health) {
            if (x == m - 1 && y == n - 1 && health > 0) {
                ans = true;
                return;
            }

            if (ans) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int fx = x + dx[i];
                int fy = y + dy[i];
                if (fx >= 0 && fx < m && fy >= 0 && fy < n) {
                    int tempHealth = health - grid.get(fy).get(fx);
                    if (tempHealth > visited[fy][fx]) {
                        visited[fy][fx] = tempHealth;
                        dfs(fx, fy, tempHealth);
                    }
                }
            }
        }
    }
}
