package minsun.nonlinear;

import java.util.*;

public class LeetCode_200_NumberOfIslands {
    static int m, n;
    static int[] dx = {-1 ,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int answer = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void bfs(int x, int y, char[][] grid){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()){
            int[] cur = q.poll();

            x = cur[0];
            y = cur[1];

            for (int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (grid[nx][ny] != '1') continue;

                grid[nx][ny] = 0;

                q.offer(new int[]{nx, ny});
            }
        }
    }
}
