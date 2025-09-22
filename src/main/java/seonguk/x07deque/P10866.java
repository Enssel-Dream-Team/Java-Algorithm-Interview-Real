package seonguk.x07deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		MyDeque deque = new MyDeque(n);
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push_front":
					deque.pushFront(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.pushBack(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					bw.write(deque.popFront() + "\n");
					break;
				case "pop_back":
					bw.write(deque.popBack() + "\n");
					break;
				case "size":
					bw.write(deque.size() + "\n");
					break;
				case "empty":
					bw.write(deque.empty() + "\n");
					break;
				case "front":
					bw.write(deque.front() + "\n");
					break;
				default:
					bw.write(deque.back() + "\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}

	static class MyDeque {
		int[] arr;
		int head = 0;
		int tail = 0;
		int arrSize;
		int size = 0;

		public MyDeque(int n) {
			arr = new int[n];
			arrSize = n;
		}

		public void pushFront(int x) {
			size++;
			arr[head--] = x;
			if(head < 0) {
				head = arrSize - 1;
			}
		}

		public void pushBack(int x) {
			size++;
			tail++;
			if(tail == arrSize) {
				tail = 0;
			}
			arr[tail] = x;
		}

		public int popFront() {
			if(size == 0) {
				return -1;
			}

			size--;
			if(head == arrSize - 1) {
				head = 0;
				return arr[head];
			} else {
				return arr[++head];
			}
		}

		public int popBack() {
			if(size == 0) {
				return -1;
			}

			size--;
			int result = arr[tail--];
			if(tail == -1) {
				tail = arrSize - 1;
			}
			return result;
		}

		public int size() {
			return size;
		}

		public int empty() {
			if(size == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		public int front() {
			if(size == 0) {
				return -1;
			}

			if(head == arrSize - 1) {
				return arr[0];
			}
			return arr[head + 1];
		}

		public int back() {
			if(size == 0) {
				return -1;
			}
			return arr[tail];
		}

	}
}
