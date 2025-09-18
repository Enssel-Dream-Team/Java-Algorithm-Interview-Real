package seonguk.x05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P06198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Building> stack = new ArrayDeque<>();
		long[] arr = new long[N];

		for(int i = 0; i < N; i++) {
			long temp = Integer.parseInt(br.readLine());
			if(stack.isEmpty()) {
				stack.addLast(new Building(i, temp));
			} else if(stack.peekLast().height > temp) {
				stack.addLast(new Building(i, temp));
			} else {
				while(!stack.isEmpty() && stack.peekLast().height <= temp) {
					Building b = stack.pollLast();
					if(!stack.isEmpty()) {
						arr[stack.peekLast().idx] += arr[b.idx] + 1;
					}
				}
				stack.addLast(new Building(i, temp));
			}
		}

		while(!stack.isEmpty()) {
			Building b = stack.pollLast();
			if(!stack.isEmpty()) {
				arr[stack.peekLast().idx] += arr[b.idx] + 1;
			}
		}

		long ans = 0;
		for(long num : arr) {
			ans += num;
		}

		System.out.println(ans);
		br.close();
	}

	static class Building {
		int idx;
		long height;

		public Building(int idx, long height) {
			this.idx = idx;
			this.height = height;
		}
	}
}
