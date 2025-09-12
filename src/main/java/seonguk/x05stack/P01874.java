package seonguk.x05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P01874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Character> list = new ArrayList<>();

		int cnt = 1;
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(cnt < num) {
				for(; cnt < num; cnt++) {
					stack.push(cnt);
					list.add('+');
				}
			}
			if(cnt == num) {
				cnt++;
				list.add('+');
				list.add('-');
			} else {
				if(stack.pop() == num) {
					list.add('-');
				} else {
					flag = false;
					System.out.println("NO");
					break;
				}
			}
		}

		if(flag) {
			StringBuilder sb = new StringBuilder();
			for(char c : list) {
				sb.append(c + "\n");
			}
			System.out.println(sb.toString());
		}

		br.close();
	}
}
