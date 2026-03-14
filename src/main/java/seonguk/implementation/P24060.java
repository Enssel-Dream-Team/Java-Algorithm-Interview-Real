package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24060 {

	static int cnt = 0;
	static int ans = -1;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, N - 1);
		System.out.println(ans);

		br.close();
	}

	static void mergeSort(int[] arr, int left, int right) {
		if (ans != -1) {
			return;
		}

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		int[] temp = new int[right - left + 1];
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		i = left;
		t = 0;
		while (i <= right) {
			arr[i++] = temp[t++];
			if (check(arr[i - 1])) {
				return;
			}
		}
	}

	static boolean check(int num) {
		cnt++;
		if (cnt == K) {
			ans = num;
			return true;
		}
		return false;
	}
}
