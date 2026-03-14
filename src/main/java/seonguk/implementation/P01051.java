package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01051 {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j] - '0';
			}
		}

		int length = Math.min(N, M);
		while (length-- > 0) {
			if (checkSquare(map, length)) {
				break;
			}
		}

		System.out.println((int) Math.pow((length + 1), 2));
		br.close();
	}

	private static boolean checkSquare(int[][] map, int length) {
		for (int i = 0; i < N - length; i++) {
			for (int j = 0; j < M - length; j++) {
				if (isSquare(map, i, j, length)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSquare(int[][] map, int i, int j, int length) {
		int origin = map[i][j];
		int right = map[i][j + length];
		int bottom = map[i + length][j];
		int rightBottom = map[i + length][j + length];

		return origin == right && origin == bottom && right == rightBottom;
	}
}
