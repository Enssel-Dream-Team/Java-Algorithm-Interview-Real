package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P02583 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());	// row
		int N = Integer.parseInt(st.nextToken());	// column
		int K = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[M][N];
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			Point point1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point point2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			fillMap(map, point1, point2);
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					cnt++;
					int area = 0;

					Deque<Point> queue = new LinkedList<>();
					queue.addLast(new Point(j, i));
					map[i][j] = true;
					while (!queue.isEmpty()) {
						area++;
						Point p = queue.pollFirst();
						for (int k = 0; k < 4; k++) {
							int fx = p.x + dx[k];
							int fy = p.y + dy[k];
							if (fx >= 0 && fx < N && fy >= 0 && fy < M && !map[fy][fx]) {
								map[fy][fx] = true;
								queue.addLast(new Point(fx, fy));
							}
						}
					}

					list.add(area);
				}
			}
		}

		list.sort(Comparator.naturalOrder());
		StringBuilder sb = new StringBuilder();
		for (int num : list) {
			sb.append(num).append(" ");
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	static void fillMap(boolean[][] map, Point point1, Point point2) {
		for (int i = point1.y; i < point2.y; i++) {
			for (int j = point1.x; j < point2.x; j++) {
				map[i][j] = true;
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
