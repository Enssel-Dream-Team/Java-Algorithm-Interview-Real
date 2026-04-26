package seonguk.leetcode;

public class P01559 {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid1 = {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        char[][] grid2 = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        System.out.println(s.containsCycle(grid1));
    }

    static class Solution {

        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};

        static boolean flag = false;

        public boolean containsCycle(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        dfs(grid, visited, new Point(j, i));
                        if (flag) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        static void dfs(char[][] grid, boolean[][] visited, Point p) {
            if (flag) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int fx = p.x + dx[i];
                int fy = p.y + dy[i];
                if(fx >= 0 && fx < grid[0].length && fy >= 0 && fy < grid.length && grid[p.y][p.x] == grid[fy][fx] && !p.checkBefore(fx, fy)) {
                    if (visited[fy][fx]) {
                        flag = true;
                        return;
                    } else {
                        visited[fy][fx] = true;
                        dfs(grid, visited, new Point(fx, fy, p));
                    }
                }
            }
        }

        static class Point {
            int x, y;
            Point beforePoint;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
                this.beforePoint = null;
            }

            Point(int x, int y, Point point) {
                this.x = x;
                this.y = y;
                this.beforePoint = point;
            }

            boolean checkBefore(int x, int y) {
                if (beforePoint == null) {
                    return false;
                }
                return beforePoint.x == x && beforePoint.y == y;
            }
        }
    }
}
