package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P30804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int ans = 1;
		for (int i = 0, j = 0; j < N;) {
			if (map.size() > 2) {
				Integer cnt = map.get(arr[i]);
				if (cnt == 1) {
					map.remove(arr[i]);
				} else {
					map.put(arr[i], map.get(arr[i]) - 1);
				}
				i++;
			} else {
				map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
				if (map.size() <= 2) {
					ans = Math.max(ans, j - i + 1);
				}
				j++;
			}
		}

		System.out.println(ans);
		br.close();
	}

}
