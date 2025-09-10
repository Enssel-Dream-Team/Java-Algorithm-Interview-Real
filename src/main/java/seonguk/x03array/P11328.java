package seonguk.x03array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(compare(st.nextToken(), st.nextToken())) {
				bw.write("Possible\n");
			} else {
				bw.write("Impossible\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean compare(String original, String compare) {
		int[] oriArr = count(original);
		int[] comArr = count(compare);
		for(int i = 0; i < oriArr.length; i++) {
			if(oriArr[i] != comArr[i]) {
				return false;
			}
		}
		return true;
	}

	static int[] count(String str) {
		int[] arr = new int[26];
		for(char c : str.toCharArray()) {
			arr[c - 'a']++;
		}
		return arr;
	}
}
