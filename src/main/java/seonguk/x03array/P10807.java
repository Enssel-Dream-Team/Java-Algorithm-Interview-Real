package seonguk.x03array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[201];
		for(int i=0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + 100]++;
		}

		int V = Integer.parseInt(br.readLine());

		System.out.println(arr[V + 100]);

		br.close();
	}
}
