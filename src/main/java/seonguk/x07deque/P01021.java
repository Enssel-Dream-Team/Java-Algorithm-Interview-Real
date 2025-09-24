package seonguk.x07deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P01021 {

	static Deque<Integer> deque;
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		deque = new ArrayDeque<>();
		for(int i = 1; i < n + 1; i++) {
			deque.addLast(i);
		}

		st = new StringTokenizer(scan.nextLine());
		int ans = 0;
		for(int i = 0; i < m; i++) {
			int val = Integer.parseInt(st.nextToken());
			ans += calc(val);
		}

		System.out.println(ans);
		scan.close();
	}

	static int calc(int val) {
		int cnt = 0;
		while(deque.peekFirst() != val) {
			deque.addLast(deque.pollFirst());
			cnt++;
		}
		deque.pollFirst();
		return Math.min(cnt, n-- - cnt);
	}
}
