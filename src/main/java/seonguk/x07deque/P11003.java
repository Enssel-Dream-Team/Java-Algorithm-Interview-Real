package seonguk.x07deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		scan.nextLine();

		StringTokenizer st = new StringTokenizer(scan.nextLine());

		Deque<Integer> deque = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			pq.add(num);
			sb.append(pq.peek()).append(" ");
			deque.addLast(num);
		}

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			pq.remove(deque.pollFirst());
			pq.add(num);
			sb.append(pq.peek()).append(" ");
			deque.addLast(num);
		}

		System.out.println(sb);
		scan.close();
	}
}
