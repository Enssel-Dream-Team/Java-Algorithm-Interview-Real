package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class P02146 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Deque<Point> que = new LinkedList<>();
		int island = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visitCheck(map, visited, que, j, i, island++);
				}
			}
		}

		int ans = 0;
		boolean flag = false;
		Set<Point> set = new HashSet<>();
		while (!que.isEmpty() && !flag) {
			Point p = que.pollFirst();
			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];

				if (fx >= 0 && fx < N && fy >= 0 && fy < N) {
					Point next = new Point(fx, fy, p.cnt + 1, p.island);
					if (map[fy][fx] > 0 && map[fy][fx] != p.island) {
						ans = p.cnt;
						flag = true;
						break;
					} else if (!set.contains(next)) {
						que.addLast(next);
						set.add(next);
					}
				}
			}
		}

		System.out.println(ans);
	}

	static void visitCheck(int[][] map, boolean[][] visited, Deque<Point> que, int x, int y, int island) {
		Deque<Point> queue = new LinkedList<>();
		queue.addLast(new Point(x, y, 1, island));
		visited[y][x] = true;
		map[y][x] = island;

		while (!queue.isEmpty()) {
			Point p =  queue.pollLast();

			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];
				if (fx >= 0 && fx < N && fy >= 0 && fy < N && !visited[fy][fx]) {
					visited[fy][fx] = true;
					if (map[fy][fx] == 0) {
						que.addLast(new Point(fx, fy, 1, island));
					} else {
						map[fy][fx] = island;
						queue.addLast(new Point(fx, fy, 1, island));
					}
				}
			}
		}
	}

	static class Point {
		int x, y, cnt, island;

		public Point(int x, int y, int cnt, int island) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.island = island;
		}

		@Override
		public boolean equals(Object o) {
			Point p = (Point)o;
			return p.x == this.x && p.y == this.y && p.island == this.island;
		}

		@Override
		public int hashCode() {
			return x * 100 + y;
		}
	}
}
