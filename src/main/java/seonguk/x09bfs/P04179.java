package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P04179 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		Deque<Point> queue = new ArrayDeque<>();
		Point jihoon = null;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F') {
					queue.addLast(new Point(j, i, 0, 'F'));
				} else if (map[i][j] == 'J') {
					jihoon = new Point(j, i, 1, 'J');
				}
			}
		}

		if (jihoon != null) {
			queue.addLast(jihoon);
		}

		int ans = -1;
		while (!queue.isEmpty()) {
			Point p = queue.pollFirst();
			if (p.status == 'J' && (p.x == 0 || p.x == C - 1 || p.y == 0 || p.y == R - 1)) {
				ans = p.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];

				if (fx >= 0 && fx < C && fy >= 0 && fy < R && (map[fy][fx] == '.' || map[fy][fx] == 'J')) {
					if (p.status == 'F') {
						map[fy][fx] = 'F';
						queue.addLast(new Point(fx, fy, p.cnt, 'F'));
					} else if (map[fy][fx] == '.') {
						map[fy][fx] = 'J';
						queue.addLast(new Point(fx, fy, p.cnt + 1, 'J'));
					}
				}
			}
		}

		if (ans >= 0) {
			System.out.println(ans);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	static class Point {
		int x, y, cnt;
		char status;

		public Point(int x, int y, int cnt, char status) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.status = status;
		}
	}
}
