package seonguk.x06queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		MyQueue queue = new MyQueue(N);
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				queue.push(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop")) {
				bw.write(queue.pop() + "\n");
			} else if (str.equals("size")) {
				bw.write(queue.size() + "\n");
			} else if (str.equals("empty")) {
				bw.write(queue.empty() + "\n");
			} else if (str.equals("front")) {
				bw.write(queue.front() + "\n");
			} else {
				bw.write(queue.back() + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static class MyQueue {
		int[] arr;
		int head = 0;
		int tail = 0;

		public MyQueue(int N) {
			arr= new int[N];
		}

		void push(int x) {
			arr[tail++] = x;
		}

		int pop() {
			if(head == tail) {
				return -1;
			}

			return arr[head++];
		}

		int size() {
			return tail - head;
		}

		int empty() {
			if(head == tail) {
				return 1;
			} else {
				return 0;
			}
		}

		int front() {
			if(head == tail) {
				return -1;
			}

			return arr[head];
		}

		int back() {
			if(head == tail) {
				return -1;
			}

			return arr[tail - 1];
		}
	}
}