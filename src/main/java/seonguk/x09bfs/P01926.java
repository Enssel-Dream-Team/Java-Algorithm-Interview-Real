package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P01926 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n =  Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		boolean[][] isVisited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int maxSize = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					cnt++;
					Deque<Point> queue = new LinkedList<>();
					queue.add(new Point(j, i));
					isVisited[i][j] = true;
					int size = 0;

					while(!queue.isEmpty()) {
						size++;
						Point p = queue.poll();
						for (int k = 0; k < 4; k++) {
							int fx = p.x + dx[k];
							int fy = p.y + dy[k];

							if(fx >= 0 && fy >= 0 && fx < m && fy < n && map[fy][fx] == 1 && !isVisited[fy][fx]) {
								isVisited[fy][fx] = true;
								queue.add(new Point(fx, fy));
							}
						}
					}
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxSize);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
