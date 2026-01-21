package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P20057 {

	static Map<Integer, Point[]> tornado = new HashMap<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;

	public static void main(String[] args) throws IOException {
		init();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = N / 2;
		int y = N / 2;
		int size = 1;
		int dir = 0;

		int ans = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < size; k++) {
					x += dx[dir];
					y += dy[dir];
					ans += move(map, x, y, dir, tornado.get(dir));
				}
				dir = (dir + 1) % 4;
			}
			size++;
		}

		for (int i = 0; i < N - 1; i++) {
			x += dx[dir];
			y += dy[dir];
			ans += move(map, x, y, dir, tornado.get(dir));
		}

		System.out.println(ans);
		br.close();
	}

	private static int move(int[][] map, int x, int y, int dir, Point[] points) {
		int ori = map[y][x];
		int remain = map[y][x];
		int outBoundary = 0;

		for (int i = 0; i < 9; i++) {
			Point p = points[i];
			int sand = (ori * p.percent) / 100;
			int fx = x + p.x;
			int fy = y + p.y;
			outBoundary += calcOut(map, fx, fy, sand);
			remain -= sand;
		}
		int fx = x + dx[dir];
		int fy = y + dy[dir];
		outBoundary += calcOut(map, fx, fy, remain);
		map[y][x] = 0;

		return outBoundary;
	}

	private static int calcOut(int[][] map, int fx, int fy, int sand) {
		int result = 0;

		if (fx >= 0 && fx < N && fy >= 0 && fy < N) {
			map[fy][fx] += sand;
		} else {
			result += sand;
		}

		return result;
	}

	static void init() {
		Point[] leftPoints = new Point[9];
		Point[] rightPoints = new Point[9];
		Point[] upPoints = new Point[9];
		Point[] downPoints = new Point[9];

		leftPoints[0] = new Point(-2, 0, 5);
		leftPoints[1] = new Point(-1, -1, 10);
		leftPoints[2] = new Point(-1, 1, 10);
		leftPoints[3] = new Point(0, -2, 2);
		leftPoints[4] = new Point(0, -1, 7);
		leftPoints[5] = new Point(0, 2, 2);
		leftPoints[6] = new Point(0, 1, 7);
		leftPoints[7] = new Point(1, -1, 1);
		leftPoints[8] = new Point(1, 1, 1);

		for (int i = 0; i < 9; i++) {
			Point p = leftPoints[i];
			rightPoints[i] = new Point(-p.x, p.y, p.percent);
		}

		for (int i = 0; i < 9; i++) {
			Point p = leftPoints[i];
			upPoints[i] = new Point(p.y, p.x, p.percent);
		}

		for (int i = 0; i < 9; i++) {
			Point p = rightPoints[i];
			downPoints[i] = new Point(p.y, p.x, p.percent);
		}

		tornado.put(0, leftPoints);
		tornado.put(1, downPoints);
		tornado.put(2, rightPoints);
		tornado.put(3, upPoints);
	}

	static class Point {
		int x;
		int y;
		int percent;

		Point(int x, int y, int percent) {
			this.x = x;
			this.y = y;
			this.percent = percent;
		}
	}
}
