package seonguk.x07deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P05430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			boolean isReverse = false;
			char[] commands = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();

			String str = br.readLine();
			String[] arr = str.substring(1, str.length() - 1).split(",");
			for(int i = 0; i < n; i++) {
				deque.addLast(Integer.parseInt(arr[i]));
			}

			boolean flag = false;
			for(char c : commands) {
				if(c == 'R') {
					isReverse = !isReverse;
				} else {
					if(deque.isEmpty()) {
						flag = true;
					} else {
						calc(deque, isReverse);
					}
				}
			}
			if(flag) {
				bw.write("error\n");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(!isReverse) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollFirst());
						sb.append(",");
					}
					if(sb.charAt(sb.length() - 1) == ',') {
						sb.deleteCharAt(sb.length() - 1);
					}
				} else {
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast());
						sb.append(",");
					}
					if(sb.charAt(sb.length() - 1) == ',') {
						sb.deleteCharAt(sb.length() - 1);
					}
				}
				sb.append("]");

				bw.write(sb.toString() + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static void calc(Deque<Integer> deque, boolean isReverse) {
		if(!isReverse) {
			deque.pollFirst();
		} else {
			deque.pollLast();
		}
	}
}
