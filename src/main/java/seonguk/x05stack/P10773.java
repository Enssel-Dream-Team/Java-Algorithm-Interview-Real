package seonguk.x05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}

		int ans = 0;
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}

		System.out.println(ans);

		br.close();
	}
}
