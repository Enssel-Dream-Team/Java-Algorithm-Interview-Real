package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P11559 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int ans = 0;
		while (checkPuyo(map)) {
			ans++;
			setMap(map);
		}

		System.out.println(ans);
		br.close();
	}

	static void setMap(char[][] map) {
		int[] bottom = new int[6];
		Arrays.fill(bottom, 11);
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					if (i != bottom[j]) {
						map[bottom[j]][j] = map[i][j];
						map[i][j] = '.';
					}
					bottom[j]--;
				}
			}
		}
	}

	static boolean checkPuyo(char[][] map) {
		boolean[][] visited = new boolean[12][6];
		boolean result = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					List<Point> list = bfs(map, visited, new Point(j, i), map[i][j]);
					if (list.size() >= 4) {
						result = true;
						setUsedPoint(map, list);
					}
				}
			}
		}

		return result;
	}

	static void setUsedPoint(char[][] map, List<Point> list) {
		for (Point p : list) {
			map[p.y][p.x] = '.';
		}
	}

	static List<Point> bfs(char[][] map, boolean[][] visited, Point point, char c) {
		List<Point> result = new ArrayList<>();
		result.add(point);
		Deque<Point> q = new LinkedList<>();
		q.addLast(point);
		visited[point.y][point.x] = true;

		while (!q.isEmpty()) {
			Point p = q.pollFirst();

			for (int i = 0; i < 4; i++) {
				int fx = p.x + dx[i];
				int fy = p.y + dy[i];
				if (fx >= 0 && fx < 6 && fy >= 0 && fy < 12 && map[fy][fx] == c && !visited[fy][fx]) {
					visited[fy][fx] = true;
					Point next = new Point(fx, fy);
					q.addLast(next);
					result.add(next);
				}
			}
		}

		return result;
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
