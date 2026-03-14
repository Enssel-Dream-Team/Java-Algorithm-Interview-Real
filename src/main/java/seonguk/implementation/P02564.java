package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02564 {

	static int width, height;
	static int totalLength;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		totalLength = 2 * (width + height);

		int N = Integer.parseInt(br.readLine());
		Point[]	points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			points[i] = new Point(dir, position);
		}

		st = new StringTokenizer(br.readLine());
		int dir =  Integer.parseInt(st.nextToken());
		int position =  Integer.parseInt(st.nextToken());
		Point dong = new Point(dir, position);

		int ans = 0;
		for (Point point : points) {
			ans += dong.getBetweenDist(point.dist);
		}

		System.out.println(ans);
		br.close();
	}

	static class Point {

		int dist;

		public Point(int dir, int position) {
			switch (dir) {
				case 1:
					dist = position;
					break;
				case 2:
					dist = 2 * width + height - position;
					break;
				case 3:
					dist = 2 * (width + height) - position;
					break;
				case 4:
					dist = width + position;
					break;
			}
		}

		public int getBetweenDist(int dist) {
			int temp = Math.abs(this.dist - dist);

			return Math.min(temp, totalLength - temp);
		}
	}
}
