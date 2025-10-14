package seonguk.x09bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P01697 {

	static Deque<Distance> queue;
	static Set<Integer> visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		queue = new ArrayDeque<>();
		queue.addLast(new Distance(N, 0));
		visited = new HashSet<>();
		visited.add(N);

		while(queue.peekFirst().dist != K) {
			Distance dist = queue.pollFirst();
			if (dist.dist < K) {
				visit(dist.dist * 2, dist.cnt + 1);
				visit(dist.dist + 1, dist.cnt + 1);
			}
			if (dist.dist > 0) {
				visit(dist.dist - 1, dist.cnt + 1);
			}
		}

		System.out.println(queue.peekFirst().cnt);
	}

	static void visit(int dist, int cnt) {
		if (!visited.contains(dist)) {
			queue.addLast(new Distance(dist, cnt));
			visited.add(dist);
		}
	}

	static class Distance {
		int dist, cnt;

		public Distance(int dist, int cnt) {
			this.dist = dist;
			this.cnt = cnt;
		}
	}
}
