package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P10026 {

	static char[][] map;
	static int N;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int ordinal = findArea();
		int problem = findArea();

		System.out.println(ordinal + " " + problem);

		br.close();
	}

	static int findArea() {
		boolean[][] visited = new boolean[N][N];
		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					result++;
					visited[i][j] = true;
					Deque<Point> queue = new LinkedList<>();
					queue.addLast(new Point(j, i));
					char c = map[i][j];
					if (c == 'R') {
						map[i][j] = 'G';
					}

					while (!queue.isEmpty()) {
						Point p = queue.pollFirst();
						for (int k = 0; k < 4; k++) {
							int fx = p.x + dx[k];
							int fy = p.y + dy[k];

							if (fx >= 0 && fx < N && fy >= 0 && fy < N && !visited[fy][fx] && map[fy][fx] == c) {
								visited[fy][fx] = true;
								if (map[fy][fx] == 'R') {
									map[fy][fx] = 'G';
								}
								queue.addLast(new Point(fx, fy));
							}
						}
					}
				}
			}
		}
		return result;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
