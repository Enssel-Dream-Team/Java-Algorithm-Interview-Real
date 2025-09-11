package seonguk.x04linkedlist;

import java.util.Scanner;

public class P01158 {
	static int N, K;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();

		Node first = new Node(1);
		Node node = first;
		for(int i = 2; i <= N; i++) {
			Node newNode = new Node(i);
			node.next = newNode;
			node = newNode;
		}
		node.next = first;

		calc(node);
		scan.close();
	}

	static void calc(Node node) {
		StringBuilder sb = new StringBuilder("<");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K - 1; j++) {
				node = node.next;
			}
			sb.append(node.next.val);
			sb.append(", ");
			node.remove();
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

	static class Node {
		Node next;
		int val;

		public Node(int val) {
			this.val = val;
		}

		public void remove() {
			next = next.next;
		}
	}
}
