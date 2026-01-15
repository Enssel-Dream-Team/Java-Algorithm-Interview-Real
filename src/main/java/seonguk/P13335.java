package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P13335 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int ans = 0;
		st = new StringTokenizer(br.readLine());
		Deque<Integer> bridge = init(w);

		for (int i = 0; i < n; i++) {
			int load = Integer.parseInt(st.nextToken());
			if (L < load) {
				while (L < load) {
					int num = bridge.pollFirst();
					bridge.addLast(0);
					L += num;
					ans++;
				}
				bridge.pollLast();
				L -= load;
				bridge.addLast(load);
			} else {
				L -= load;
				int num = bridge.pollFirst();
				L += num;
				bridge.addLast(load);
				ans++;
			}
		}
		ans += w;

		System.out.println(ans);
		br.close();
	}

	static Deque<Integer> init(int w) {
		Deque<Integer> result = new LinkedList<>();
		while (w-- > 0) {
			result.addLast(0);
		}
		return result;
	}
}
