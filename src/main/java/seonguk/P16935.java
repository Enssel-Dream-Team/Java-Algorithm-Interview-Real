package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16935 {

	static Integer[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new Integer[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			switch (Integer.parseInt(st.nextToken())) {
				case 1:
					firstCalc();
					break;
				case 2:
					secondCalc();
					break;
				case 3:
					thirdCalc();
					break;
				case 4:
					fourthCalc();
					break;
				case 5:
					fifthCalc();
					break;
				default:
					sixthCalc();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static void firstCalc() {
		int len = map.length;
		for (int i = 0; i < len / 2; i++) {
			change(map, i, len - 1 - i);
		}
	}

	static void secondCalc() {
		for (int i = 0; i < map.length; i++) {
			int len = map[i].length;
			for (int j = 0; j < len / 2; j++) {
				change(map[i], j, len - 1 - j);
			}
		}
	}

	static void thirdCalc() {
		int n = map.length;
		int m = map[0].length;
		Integer[][] newMap = new Integer[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[j][n - 1 - i] = map[i][j];
			}
		}

		map = newMap;
	}

	static void fourthCalc() {
		int n = map.length;
		int m = map[0].length;
		Integer[][] newMap = new Integer[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[m - 1 - j][i] = map[i][j];
			}
		}

		map = newMap;
	}

	static void fifthCalc() {
		int n = map.length;
		int m = map[0].length;
		int miniN = n / 2;
		int miniM = m / 2;

		Integer[][] temp = new Integer[miniN][miniM];
		for (int i = 0; i < miniN; i++) {
			for (int j = 0; j < miniM; j++) {
				temp[i][j] = map[i][j];
			}
		}

		groupChange(new Point(0, miniN), new Point(0, 0), miniM, miniN);
		groupChange(new Point(miniM, miniN), new Point(0, miniN), miniM, miniN);
		groupChange(new Point(miniM, 0), new Point(miniM, miniN), miniM, miniN);

		for (int i = 0; i < miniN; i++) {
			for (int j = 0; j < miniM; j++) {
				map[i][miniM + j] = temp[i][j];
			}
		}
	}

	static void sixthCalc() {
		int n = map.length;
		int m = map[0].length;
		int miniN = n / 2;
		int miniM = m / 2;

		Integer[][] temp = new Integer[miniN][miniM];
		for (int i = 0; i < miniN; i++) {
			for (int j = 0; j < miniM; j++) {
				temp[i][j] = map[i][j];
			}
		}

		groupChange(new Point(miniM, 0), new Point(0, 0), miniM, miniN);
		groupChange(new Point(miniM, miniN), new Point(miniM, 0), miniM, miniN);
		groupChange(new Point(0, miniN), new Point(miniM, miniN), miniM, miniN);

		for (int i = 0; i < miniN; i++) {
			for (int j = 0; j < miniM; j++) {
				map[miniN + i][j] = temp[i][j];
			}
		}
	}

	private static void groupChange(Point bPoint, Point aPoint, int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[aPoint.y + i][aPoint.x + j] = map[bPoint.y + i][bPoint.x + j];
			}
		}
	}

	private static void change(Object[] arr, int val1, int val2) {
		Object o = arr[val1];
		arr[val1] = arr[val2];
		arr[val2] = o;
	}

	static class Point {

		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
