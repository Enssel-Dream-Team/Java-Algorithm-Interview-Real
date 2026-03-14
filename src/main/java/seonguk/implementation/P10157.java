package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10157 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		if (K > C * R) {
			System.out.println(0);
			return;
		}

		int[][] map = new int[R][C];
		int x = 0;
		int y = R - 1;
		int dir = 0;
		for (int i = 1; i <= C * R; i++) {
			if (i == K) {
				break;
			}

			map[y][x] = i;
			int fx = x + dx[dir];
			int fy = y + dy[dir];
			if (fx >= 0 && fx < C && fy >= 0 && fy < R && map[fy][fx] == 0) {
				x = fx;
				y = fy;
			} else {
				dir = (dir + 1) % 4;
				x += dx[dir];
				y += dy[dir];
			}
		}

		System.out.println((x + 1) + " " + (R - y));

		br.close();
	}

}
