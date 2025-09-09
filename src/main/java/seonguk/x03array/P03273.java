package seonguk.x03array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P03273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int key  = Integer.parseInt(st.nextToken());
			arr[i] = key;
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int target = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			int temp = target - arr[i];
			map.put(arr[i], map.get(arr[i]) - 1);
			if(map.containsKey(temp)) {
				ans += map.get(temp);
			}
		}

		System.out.println(ans);
		br.close();
	}
}
