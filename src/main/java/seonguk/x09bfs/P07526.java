package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P07526 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Deque<Point> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.addLast(new Point(j, i, 0));
				}
			}
		}

		int ans = 0;

		while (!queue.isEmpty()) {
			Point p = queue.pollFirst();
			ans = p.cnt;

			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];

				if (fx >= 0 && fx < M && fy >= 0 && fy < N && map[fy][fx] == 0) {
					map[fy][fx] = 1;
					queue.addLast(new Point(fx, fy, p.cnt + 1));
				}
			}
		}

		boolean flag = false;

		loop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					flag = true;
					break loop;
				}
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static class Point{
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
