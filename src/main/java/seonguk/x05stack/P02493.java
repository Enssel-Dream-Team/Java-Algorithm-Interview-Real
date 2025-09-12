package seonguk.x05stack;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class P02493 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		StringTokenizer st = new StringTokenizer(scan.nextLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] ans = new int[N];
		Stack<Receiver> stack = new Stack<>();
		for(int i = N - 1; i >= 0; i--) {
			if(!stack.isEmpty() && arr[i] > stack.peek().height) {
				while (!stack.isEmpty() && arr[i] > stack.peek().height) {
					ans[stack.pop().idx] = i + 1;
				}
			}
			stack.push(new Receiver(i, arr[i]));
		}

		StringBuilder sb = new StringBuilder();
		for (int num : ans) {
			sb.append(num + " ");
		}
		System.out.println(sb.toString());
		scan.close();
	}

	static class Receiver {
		int idx, height;

		public Receiver(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
}
