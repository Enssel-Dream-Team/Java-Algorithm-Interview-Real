package seonguk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class P09375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String[] arr =  br.readLine().split(" ");
				map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
			}

			int ans = 1;
			for (int val : map.values()) {
				ans *= (val + 1);
			}
			bw.write((ans - 1) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
