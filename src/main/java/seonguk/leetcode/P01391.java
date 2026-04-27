package seonguk.leetcode;

public class P01391 {

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] grid = {{2,4,3}, {6,5,2}};
        int[][] grid = {{3,4,3,4}, {2,2,2,2}, {6,5,6,5}};
        System.out.println(s.hasValidPath(grid));
    }

    static class Solution {

        static Street[] streets;
        static int[][] grid;
        static boolean ans;
        static boolean[][] visited;
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {-1, 0, 1, 0};

        public boolean hasValidPath(int[][] grid) {
            Solution.grid = grid;
            setInit();
            visited[0][0] = true;
            dfs(0, 0, -1);
            return ans;
        }

        void dfs(int x, int y, int before) {
            if (ans) {
                return;
            }

            if (x == grid[0].length - 1 && y == grid.length - 1 && streets[grid[y][x]].getNext(before) >= 0) {
                ans = true;
                return;
            }

            Street s = streets[grid[y][x]];
            if (before == -1) {
                int next = s.val1;
                int fx = x + dx[next];
                int fy = y + dy[next];

                if (fx >= 0 && fx < grid[0].length && fy >= 0 && fy < grid.length && !visited[fy][fx]) {
                    visited[fy][fx] = true;
                    dfs(fx, fy, next);
                }

                next = s.val2;
                fx = x + dx[next];
                fy = y + dy[next];
                if (fx >= 0 && fx < grid[0].length && fy >= 0 && fy < grid.length && !visited[fy][fx]) {
                    visited[fy][fx] = true;
                    dfs(fx, fy, next);
                }
            } else {
                int next = s.getNext(before);
                if (next >= 0) {
                    int fx = x + dx[next];
                    int fy = y + dy[next];
                    if (fx >= 0 && fx < grid[0].length && fy >= 0 && fy < grid.length && !visited[fy][fx]) {
                        visited[fy][fx] = true;
                        dfs(fx, fy, next);
                    }
                }
            }
        }

        void setInit() {
            ans = false;
            visited = new boolean[grid.length][grid[0].length];

            if (streets != null) {
                return;
            }

            streets = new Street[7];
            streets[1] = new Street(3, 1);
            streets[2] = new Street(0, 2);
            streets[3] = new Street(2, 3);
            streets[4] = new Street(1, 2);
            streets[5] = new Street(3, 0);
            streets[6] = new Street(0, 1);
        }

        static class Street {
            int val1, val2;

            Street(int val1, int val2) {
                this.val1 = val1;
                this.val2 = val2;
            }

            int getNext(int before) {
                int input = (before + 2) % 4;
                if (input == val1) {
                    return val2;
                } else if (input == val2) {
                    return val1;
                } else {
                    return -1;
                }

            }
        }
    }
}
