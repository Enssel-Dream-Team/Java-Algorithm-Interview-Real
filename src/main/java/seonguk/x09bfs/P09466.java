package seonguk.x09bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P09466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Set<Integer> result = new HashSet<>();
			Set<Integer> visited = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				if (!result.contains(i) && !visited.contains(i)) {
					Set<Integer> temp = new HashSet<>();
					temp.add(i);
					int next = arr[i];
					boolean flag = true;
					while (!temp.contains(next)) {
						if (visited.contains(next)) {
							flag = false;
							break;
						}
						temp.add(next);
						visited.add(next);
						next = arr[next];
					}

					if (flag) {
						while (!result.contains(next)) {
							result.add(next);
							next = arr[next];
						}
					}
				}
			}
			bw.write(N - result.size() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
