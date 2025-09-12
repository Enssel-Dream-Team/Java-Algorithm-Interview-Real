package seonguk.x04linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Node firstNode = new Node();
		Node lastNode = new Node();
		firstNode.next = lastNode;
		lastNode.before = firstNode;

		for(char c : str.toCharArray()) {
			lastNode.add(c);
		}

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String prompt = st.nextToken();
			if(prompt.equals("L")) {
				if(lastNode.before.val != null) {
					lastNode = lastNode.before;
				}
			} else if(prompt.equals("D")) {
				if(lastNode.next != null) {
					lastNode = lastNode.next;
				}
			} else if(prompt.equals("B")) {
				lastNode.remove();
			} else {
				lastNode.add(st.nextToken().charAt(0));
			}
		}

		StringBuilder sb = new StringBuilder();
		while(firstNode.next.val != null) {
			sb.append(firstNode.next.val);
			firstNode = firstNode.next;
		}
		System.out.println(sb.toString());

		br.close();
	}

	static class Node {
		Node before;
		Node next;
		Character val;

		public Node(Character val) {
			this.val = val;
		}

		public Node() {}

		public void add(char c) {
			Node newNode = new Node(c);
			newNode.before = before;
			newNode.next = this;
			before.next = newNode;
			before = newNode;
		}

		public void remove() {
			if(before != null && before.before != null) {
				before.before.next = this;
				before = before.before;
			}
		}
	}
}
