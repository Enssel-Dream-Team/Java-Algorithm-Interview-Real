package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class P02667 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					cnt++;
					int area = 0;

					Deque<Point> queue = new LinkedList<>();
					queue.addLast(new Point(j, i));
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						area++;
						Point p = queue.pollFirst();
						for (int k = 0; k < 4; k++) {
							int fx = p.x + dx[k];
							int fy = p.y + dy[k];
							if (fx >= 0 && fx < N && fy >= 0 && fy < N && map[fy][fx] == '1' && !visited[fy][fx]) {
								visited[fy][fx] = true;
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
		sb.append(cnt).append("\n");
		for (int num : list) {
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
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
