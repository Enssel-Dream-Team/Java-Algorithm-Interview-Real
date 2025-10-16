package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P01012 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			ArrayList<Point> points = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
				points.add(new Point(x, y));
			}

			int ans = 0;
			for (Point point : points) {
				Deque<Point> queue = new LinkedList<>();
				if (map[point.y][point.x] == 1) {
					ans++;
					map[point.y][point.x] = 0;
					queue.addFirst(point);

					while (!queue.isEmpty()) {
						Point temp = queue.pollFirst();
						for (int i = 0; i < 4; i++) {
							int fx = temp.x + dx[i];
							int fy = temp.y + dy[i];

							if (fx >= 0 && fx < M && fy >= 0 && fy < N && map[fy][fx] == 1) {
								map[fy][fx] = 0;
								queue.addLast(new Point(fx, fy));
							}
						}
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
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
