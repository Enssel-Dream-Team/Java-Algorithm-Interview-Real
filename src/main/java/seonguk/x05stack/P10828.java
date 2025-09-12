package seonguk.x05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack stack = new Stack(N);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop")) {
				sb.append(stack.pop() + "\n");
			} else if(str.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if(str.equals("empty")) {
				sb.append(stack.empty() + "\n");
			} else {
				sb.append(stack.top() + "\n");
			}
		}
		System.out.println(sb.toString());

		br.close();
	}

	static class Stack {
		private Integer[] arr;
		private int idx = 0;

		public Stack(int size) {
			arr = new Integer[size + 1];
		}

		public void push(int num) {
			arr[++idx] = num;
		}

		public int pop() {
			if(idx == 0) {
				return -1;
			}

			int result = arr[idx];
			arr[idx--] = null;
			return result;
		}

		public int size() {
			return idx;
		}

		public int empty() {
			if(idx == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		public int top() {
			if(idx == 0) {
				return -1;
			}
			return arr[idx];
		}
	}
}
