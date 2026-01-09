package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02477 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] lengthes = new int[6];
		int[] check = new int[5];
		Arrays.fill(check, -1);

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			lengthes[i] = length;
			if (check[dir] == -1) {
				check[dir] = i;
			} else {
				check[dir] = -1;
			}
		}

		int endIdx = calcEnd(check);
		int startIdx = (6 + endIdx - 1) % 6;

		int minStart = (endIdx + 2) % 6;
		int minEnd = (endIdx + 3) % 6;

		System.out.println((lengthes[startIdx] * lengthes[endIdx] - lengthes[minStart] * lengthes[minEnd]) * K);
		br.close();
	}

	private static int calcEnd(int[] arr) {
		int[] idxArr = new int[2];
		int j = 0;
		for (int i = 1; i < 5; i++) {
			if (arr[i] >= 0) {
				idxArr[j++] = arr[i];
			}
		}

		int min = Math.min(idxArr[0], idxArr[1]);
		int max = Math.max(idxArr[0], idxArr[1]);

		return isEnd(min, max);
	}

	private static int isEnd(int min, int max) {
		if (min + 1 == max) {
			return max;
		}
		return min;
	}
}
