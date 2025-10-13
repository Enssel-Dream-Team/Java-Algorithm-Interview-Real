package seonguk.x08stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P03986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (check(br.readLine())) {
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}

	static boolean check(String str) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : str.toCharArray()) {
			if (stack.isEmpty() || c != stack.peekLast()) {
				stack.addLast(c);
			} else {
				stack.pollLast();
			}
		}

		return stack.isEmpty();
	}
}
