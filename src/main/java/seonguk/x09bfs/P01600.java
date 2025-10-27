package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class P01600 {

	static int[] horseDx = {1, -1, 2, -2, 1, -1, 2, -2};
	static int[] horseDy = {2, 2, 1, 1, -2, -2, -1, -1};
	static int[] monkeyDx = {1, 0, -1, 0};
	static int[] monkeyDy = {0, -1, 0, 1};

	static int W, H, K;
	static int[][] map;
	static Deque<Point> queue;
	static Set<Point> visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue = new LinkedList<>();
		Point init = new Point(0, 0, K, 0);
		queue.addLast(init);
		visited = new HashSet<>();
		visited.add(init);
		int ans = -1;

		while (!queue.isEmpty()) {
			Point p = queue.pollFirst();
			if (p.x == W - 1 && p.y == H - 1) {
				ans = p.cnt;
				break;
			}

			if (p.horseMove > 0) {
				horseMove(p);
			}
			monkeyMove(p);
		}

		System.out.println(ans);
		br.close();
	}

	static void monkeyMove(Point p) {
		for (int i = 0; i < 4; i++) {
			int fx = p.x + monkeyDx[i];
			int fy = p.y + monkeyDy[i];
			Point next = new Point(fx, fy, p.horseMove, p.cnt + 1);
			if (fx >= 0 && fx < W && fy >= 0 && fy < H && map[fy][fx] == 0 && !visited.contains(next)) {
				visited.add(next);
				queue.addLast(next);
			}
		}
	}

	static void horseMove(Point p) {
		for (int i = 0; i < 8; i++) {
			int fx = p.x + horseDx[i];
			int fy = p.y + horseDy[i];
			Point next = new Point(fx, fy, p.horseMove - 1, p.cnt + 1);
			if (fx >= 0 && fx < W && fy >= 0 && fy < H && map[fy][fx] == 0 && !visited.contains(next)) {
				visited.add(next);
				queue.addLast(next);
			}
		}
	}

	static class Point {
		int x, y;
		int horseMove;
		int cnt;

		public Point(int x, int y, int horseMove, int cnt) {
			this.x = x;
			this.y = y;
			this.horseMove = horseMove;
			this.cnt = cnt;
		}

		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			return this.x == p.x && this.y == p.y && this.horseMove == p.horseMove;
		}

		@Override
		public int hashCode() {
			return this.x * 10000 + this.y * 100 + this.horseMove;
		}
	}
}
