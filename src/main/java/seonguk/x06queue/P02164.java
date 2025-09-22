package seonguk.x06queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P02164 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Deque<Integer> deque = new ArrayDeque<Integer>();

		for(int i = 1; i <= n; i++) {
			deque.addLast(i);
		}

		while(deque.size() > 1) {
			deque.pollFirst();
			deque.addLast(deque.pollFirst());
		}

		System.out.println(deque.pollFirst());
		scan.close();
	}
}
