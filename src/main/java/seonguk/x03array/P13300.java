package seonguk.x03array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = toInt(st);
		int M = toInt(st);

		int[][] arr = new int[7][2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = toInt(st);
			int grade = toInt(st);
			arr[grade][sex]++;
		}

		int ans = 0;
		for(int i = 1; i <= 6; i++) {
			int[] temp = arr[i];
			ans += add(temp[0], M);
			ans += add(temp[1], M);
		}

		System.out.println(ans);
		br.close();
	}

	private static int toInt(StringTokenizer st) throws IOException {
		return Integer.parseInt(st.nextToken());
	}

	private static int add(int num, int M) {
		int result = num / M;
		if(num % M != 0) {
			result += 1;
		}
		return result;
	}
}
