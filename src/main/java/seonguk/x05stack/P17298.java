package seonguk.x05stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P17298 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		int[] ans = new int[N];
		Arrays.fill(ans, -1);

		Deque<Num> stack = new ArrayDeque<>();

		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty() && stack.peekLast().val < n) {
				ans[stack.pollLast().idx] = n;
			}
			stack.addLast(new Num(i, n));
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());

		scan.close();
	}

	static class Num {
		int idx, val;

		public Num(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
