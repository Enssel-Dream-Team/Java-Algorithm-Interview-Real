package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P07562 {

	static int[] dx = {2, 2, 1, -1, -2, -2, 1, -1};
	static int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while (t-- > 0) {
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			boolean[][] visited = new boolean[I][I];

			Deque<Point> queue = new LinkedList<>();
			queue.add(start);
			visited[start.y][start.x] = true;

			int ans = 0;
			while (!queue.isEmpty()) {
				Point current = queue.pollFirst();
				if (current.x == end.x && current.y == end.y) {
					ans = current.cnt;
					break;
				}

				for (int i = 0; i < 8; i++) {
					int fx = current.x + dx[i];
					int fy = current.y + dy[i];
					if (fx >= 0 && fx < I && fy >= 0 && fy < I && !visited[fy][fx]) {
						visited[fy][fx] = true;
						queue.addLast(new Point(fx, fy, current.cnt + 1));
					}
				}
			}

			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
