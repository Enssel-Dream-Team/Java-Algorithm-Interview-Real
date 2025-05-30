package seonguk.nonlinear;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_200_NumberOfIslands {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static char[][] grid;
	static int maxX, maxY;

	public int numIslands(char[][] grid) {
		int ans = 0;

		this.grid = grid;
		maxX = grid[0].length;
		maxY = grid.length;
		for(int i = 0; i < maxY; i++) {
			for(int j = 0; j < maxX; j++) {
				if(grid[i][j] == '1') {
					ans++;
					bfs(j, i);
				}
			}
		}

		return ans;
	}

	void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		grid[y][x] = '0';
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int i = 0; i < 4; i++) {
				int fx = point.x + dx[i];
				int fy = point.y + dy[i];
				if(fx >= 0 && fx < maxX && fy >= 0 && fy < maxY && grid[fy][fx] == '1') {
					grid[fy][fx] = '0';
					queue.add(new Point(fx, fy));
				}
			}
		}
	}

	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
