package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P02178 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][] isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		Deque<Point> queue = new LinkedList<>();
		queue.addLast(new Point(0, 0, 1));
		isVisited[0][0] = true;
		int ans = -1;

		while (!queue.isEmpty()) {
			Point p = queue.pollFirst();
			if (p.x == M - 1 && p.y == N - 1) {
				ans = p.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];

				if(fx >= 0 && fx < M && fy >= 0 && fy < N && map[fy][fx] == '1' && !isVisited[fy][fx]) {
					isVisited[fy][fx] = true;
					queue.addLast(new Point(fx, fy, p.cnt + 1));
				}
			}
		}
		System.out.println(ans);
		br.close();
	}

	static class Point {
		int cnt;
		int x, y;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
