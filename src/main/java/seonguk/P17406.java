package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17406 {

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Rotation[] rotations = new Rotation[K];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotations[i] = new Rotation(r, c, s);
		}

		calc(map, rotations, new boolean[K], K);

		System.out.println(result);
		br.close();
	}

	static void calc(int[][] map, Rotation[] rotations, boolean[] flag, int K) {
		if (K == 0) {
			int ans = Integer.MAX_VALUE;
			for (int[] nums : map) {
				int temp = 0;
				for (int num : nums) {
					temp += num;
				}
				ans = Math.min(ans, temp);
			}
			result = Math.min(result, ans);
			return;
		}

		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				continue;
			}

			flag[i] = true;
			rotations[i].rotate(map);
			calc(map, rotations, flag, K - 1);
			rotations[i].reverse(map);
			flag[i] = false;
		}
	}

	static class Rotation {
		int r, c, s;

		public Rotation(int r, int c, int s) {
			this.r = r - 1;
			this.c = c - 1;
			this.s = s;
		}

		public void rotate(int[][] map) {
			for (int i = 1; i <= s; i++) {
				rotate(map, i);
			}
		}

		private void rotate(int[][] map, int dist) {
			int temp = map[r - dist][c - dist];
			for (int i = 0; i < 2 * dist; i++) {
				map[r - dist + i][c - dist] = map[r - dist + i + 1][c - dist];
			}
			for (int i = 0; i < 2 * dist; i++) {
				map[r + dist][c - dist + i] = map[r + dist][c - dist + i + 1];
			}
			for (int i = 0; i < 2 * dist; i++) {
				map[r + dist - i][c + dist] = map[r + dist - i - 1][c + dist];
			}
			for (int i = 0; i < 2 * dist - 1; i++) {
				map[r - dist][c + dist - i] = map[r - dist][c + dist - i - 1];
			}
			map[r - dist][c - dist + 1] = temp;
		}

		public void reverse(int[][] map) {
			for (int i = 1; i <= s; i++) {
				reverse(map, i);
			}
		}

		private void reverse(int[][] map, int dist) {
			int temp = map[r - dist][c - dist];
			for (int i = 0; i < 2 * dist; i++) {
				map[r - dist][c - dist + i] = map[r - dist][c - dist + i + 1];
			}
			for (int i = 0; i < 2 * dist; i++) {
				map[r - dist + i][c + dist] = map[r - dist + i + 1][c + dist];
			}
			for (int i = 0; i < 2 * dist; i++) {
				map[r + dist][c + dist - i] = map[r + dist][c + dist - i - 1];
			}
			for (int i = 0; i < 2 * dist - 1; i++) {
				map[r + dist - i][c - dist] = map[r + dist - i - 1][c - dist];
			}
			map[r - dist + 1][c - dist] = temp;
		}
	}
}
