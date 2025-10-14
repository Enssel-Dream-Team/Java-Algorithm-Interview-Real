package seonguk.x08stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P09012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			if (check(br.readLine())) {
				bw.write("YES\n");
			} else  {
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean check(String str) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.addLast(c);
			} else if (stack.isEmpty()) {
				return false;
			} else {
				stack.pollLast();
			}
		}

		return stack.isEmpty();
	}
}
