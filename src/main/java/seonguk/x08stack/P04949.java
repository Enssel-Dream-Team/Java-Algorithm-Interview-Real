package seonguk.x08stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P04949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		while(!str.equals(".")) {
			Deque<Integer> deque = new ArrayDeque<>();
			boolean flag = true;
			for (char c : str.toCharArray()) {
				int num = checkParentheses(c);
				if(num < 0) {
					deque.addLast(num);
				} else if (num > 0) {
					if (deque.isEmpty() || deque.pollLast() + num != 0) {
						flag = false;
						break;
					}
				}
			}

			if(deque.isEmpty() && flag) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}

			str = br.readLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int checkParentheses(char c) {
		switch (c) {
			case '(':
				return -1;
			case  '[':
				return -2;
			case ')':
				return 1;
			case ']':
				return 2;
			default:
				return 0;
		}
	}
}
