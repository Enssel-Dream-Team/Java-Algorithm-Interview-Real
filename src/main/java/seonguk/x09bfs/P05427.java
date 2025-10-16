package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P05427 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			char[][] map = new char[R][C];
			Deque<Point> queue = new ArrayDeque<>();
			Point start = null;
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*') {
						queue.addLast(new Point(j, i, 0, '*'));
					} else if (map[i][j] == '@') {
						start = new Point(j, i, 1, '@');
					}
				}
			}

			if (start != null) {
				queue.addLast(start);
			}

			int ans = -1;
			while (!queue.isEmpty()) {
				Point p = queue.pollFirst();
				if (p.status == '@' && (p.x == 0 || p.x == C - 1 || p.y == 0 || p.y == R - 1)) {
					ans = p.cnt;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int fx = p.x + dx[i];
					int fy = p.y + dy[i];

					if (fx >= 0 && fx < C && fy >= 0 && fy < R && (map[fy][fx] == '.' || map[fy][fx] == '@')) {
						if (p.status == '*') {
							map[fy][fx] = '*';
							queue.addLast(new Point(fx, fy, p.cnt, '*'));
						} else if (map[fy][fx] == '.') {
							map[fy][fx] = '@';
							queue.addLast(new Point(fx, fy, p.cnt + 1, '@'));
						}
					}
				}
			}

			if (ans >= 0) {
				bw.write(ans + "\n");
			} else {
				bw.write("IMPOSSIBLE\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
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
