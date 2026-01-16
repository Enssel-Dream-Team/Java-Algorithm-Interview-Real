package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01913 {

	static int N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[] result = setMap(map, M);

		StringBuilder sb = new StringBuilder();
		Arrays.stream(map).forEach(arr -> {
			Arrays.stream(arr).forEach(num -> sb.append(num + " "));
			sb.append("\n");
		});
		sb.append(result[1] + 1).append(" ").append(result[0] + 1);
		System.out.println(sb);
		br.close();
	}

	static int[] setMap(int[][] map, int target) {
		int[] result = new int[2];
		Arrays.fill(result, -1);

		int val = 1;
		int dir = 0;

		int x = N / 2;
		int y = N / 2;
		map[y][x] = val;
		if (val == target) {
			result[0] = x;
			result[1] = y;
		}

		int dirChange = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < (dirChange + 1) / 2; k++) {
					x += dx[dir];
					y += dy[dir];
					map[y][x] = ++val;
					if (val == target) {
						result[0] = x;
						result[1] = y;
					}
				}
				dir = (dir + 1) % 4;
				dirChange++;
			}
		}
		for (int i = N - 2; i >= 0; i--) {
			map[i][0] = ++val;
			if (result[0] == -1 && val == target) {
				result[0] = 0;
				result[1] = i;
			}
		}

		return result;
	}
}
