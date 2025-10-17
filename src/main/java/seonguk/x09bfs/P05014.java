package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class P05014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());	// 총 층수
		int S = Integer.parseInt(st.nextToken());	// 시작지점
		int G = Integer.parseInt(st.nextToken());	// 목표지점
		int U = Integer.parseInt(st.nextToken());	// 위로 가는 층수
		int D = Integer.parseInt(st.nextToken());	// 아래로 가는 층수

		Deque<Floor> queue = new LinkedList<>();
		queue.addLast(new Floor(S, 0));
		Set<Integer> visited = new HashSet<>();
		visited.add(S);

		int ans = -1;
		while (!queue.isEmpty()) {
			Floor f = queue.pollFirst();
			if (f.floor == G) {
				ans = f.cnt;
				break;
			}

			if (f.floor - D > 0 && !visited.contains(f.floor - D)) {
				queue.addLast(new Floor(f.floor - D, f.cnt + 1));
				visited.add(f.floor - D);
			}
			if (f.floor + U <= F && !visited.contains(f.floor + U)) {
				queue.addLast(new Floor(f.floor + U, f.cnt + 1));
				visited.add(f.floor + U);
			}
		}

		if (ans >= 0) {
			System.out.println(ans);
		} else {
			System.out.println("use the stairs");
		}
	}

	static class Floor {
		int floor, cnt;

		public Floor(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}
}
