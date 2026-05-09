package seonguk.leetcode;

public class P01914 {
    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int layer = Math.min(m, n) / 2;

            int[][] result = new int[m][n];
            for(int i = 0; i < layer; i++) {
                calcRotation(grid, result, k, i);
            }
            return result;
        }

        private void calcRotation(int[][] grid, int[][] result, int k, int i) {
            int m = grid.length;
            int n = grid[0].length;

            int startR = i;
            int startC = i;
            int endR = m - i;
            int endC = n - i;
            int oneCycle = 2 * (m - 2 * i) + 2 * (n - 2 * i - 2);

            k %= oneCycle;
            int[] nums = new int[oneCycle];
            int idx = 0;
            // nums init
            for (int j = startR; j < endR; j++) {
                nums[idx++] = grid[j][startC];
            }
            for (int j = startC + 1; j < endC - 1; j++) {
                nums[idx++] = grid[endR - 1][j];
            }
            for (int j = endR - 1; j >= startR; j--) {
                nums[idx++] = grid[j][endC - 1];
            }
            for (int j = endC - 2; j > startC; j--) {
                nums[idx++] = grid[startR][j];
            }

            // result set
            idx = 0;
            for (int j = startR; j < endR; j++) {
                result[j][startC] = nums[(oneCycle + idx++ - k) % oneCycle];
            }
            for (int j = startC + 1; j < endC - 1; j++) {
                result[endR - 1][j] = nums[(oneCycle + idx++ - k) % oneCycle];
            }
            for (int j = endR - 1; j >= startR; j--) {
                result[j][endC - 1] = nums[(oneCycle + idx++ - k) % oneCycle];
            }
            for (int j = endC - 2; j > startC; j--) {
                result[startR][j] = nums[(oneCycle + idx++ - k) % oneCycle];
            }
        }
    }
}
