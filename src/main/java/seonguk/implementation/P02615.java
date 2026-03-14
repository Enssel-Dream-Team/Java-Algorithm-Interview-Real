package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02615 {

	static int[][] board;
	static int[] dx = {1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				int color = board[i][j];
				if (color != 0) {
					for (int k = 0; k < 4; k++) {
						int fx = j + dx[k];
						int fy = i + dy[k];
						if (fx >= 0 && fx < 19 && fy >= 0 && fy < 19 && board[fy][fx] == color && checkBefore(j, i, k, color)) {
							if (serialCount(fx, fy, k, color, 2) == 5) {
								StringBuilder sb = new StringBuilder();
								sb.append(color).append("\n");
								sb.append(i + 1).append(" ").append(j + 1);
								System.out.println(sb);
								return;
							}
						}
					}
				}
			}
		}

		System.out.println(0);
	}

	private static boolean checkBefore(int x, int y, int k, int color) {
		int fx = x - dx[k];
		int fy = y - dy[k];
		if (fx < 0 || fx == 19 || fy < 0 || fy == 19) {
			return true;
		}
		return fx < 19 && fy < 19 && board[fy][fx] != color;
	}

	static int serialCount(int x, int y, int dir, int color, int cnt) {
		int fx = x + dx[dir];
		int fy = y + dy[dir];
		if (fx >= 0 && fx < 19 && fy >= 0 && fy < 19 && board[fy][fx] == color) {
			return serialCount(fx, fy, dir, color, cnt + 1);
		}
		return cnt;
	}

}
