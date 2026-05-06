package seonguk.leetcode;

public class P01861 {
    class Solution {
        public char[][] rotateTheBox(char[][] boxGrid) {
            char[][] rotatedBox = rotateBox(boxGrid);
            applyGravity(rotatedBox);

            return rotatedBox;
        }

        private void applyGravity(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            for (int j = 0; j < n; j++) {
                int ground = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    char c = grid[i][j];
                    if (c == '#') {
                        grid[i][j] = '.';
                        grid[ground--][j] = '#';
                    } else if (c == '*') {
                        ground = i - 1;
                    }
                }
            }
        }

        private char[][] rotateBox(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            char[][] rotatedBox = new char[n][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedBox[j][m - 1 - i] = grid[i][j];
                }
            }

            return rotatedBox;
        }
    }
}
