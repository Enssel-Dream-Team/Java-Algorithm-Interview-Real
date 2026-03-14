package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P07490 {

	static char[] operators = {' ', '+', '-'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<String>[] result = init();

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			List<String> list = result[num];

			for (String s : list) {
				sb.append(s);
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static List<String>[] init() {
		List<String>[] result = new ArrayList[10];
		List<String>[] arr = new ArrayList[10];

		for (int i = 0; i < 10; i++) {
			result[i] = new ArrayList<>();
			arr[i] = new ArrayList<>();
		}

		arr[1].add("1");
		for (int i = 2; i < 10; i++) {
			makeResult(arr[i - 1], arr[i], i, result);
		}

		return result;
	}

	static void makeResult(List<String> ori, List<String> next, int val, List<String>[] map) {
		for (String s : ori) {
			for (char c : operators) {
				String nextStr = s + c + val;
				next.add(nextStr);
				if (isZero(nextStr)) {
					map[val].add(nextStr + "\n");
				}
			}
		}
	}

	static boolean isZero(String str) {
		String val = str.replace(" ", "");
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		for (char c : val.toCharArray()) {
			switch (c) {
				case '+':
					list.add(sb.toString());
					sb = new StringBuilder();
					list.add("+");
					break;
				case '-':
					list.add(sb.toString());
					sb = new StringBuilder();
					list.add("-");
					break;
				default:
					sb.append(c);
			}
		}
		list.add(sb.toString());

		int ans = Integer.parseInt(list.get(0));
		for (int i = 1; i < list.size(); i += 2) {
			switch (list.get(i)) {
				case "+":
					ans += Integer.parseInt(list.get(i + 1));
					break;
				default:
					ans -= Integer.parseInt(list.get(i + 1));
			}
		}
		return ans == 0;
	}

}
