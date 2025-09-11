package seonguk.x04linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			Node head = keyLog(br.readLine());
			printPassword(head);
		}

		br.close();
	}

	static Node keyLog(String str) {
		Node head = new Node();
		Node node = new Node();
		head.right = node;
		node.left = head;

		for(char c : str.toCharArray()) {
			if(c == '-') {
				node.backspace();
			} else if(c == '<') {
				if(node.left.val != null) {
					node = node.left;
				}
			} else if(c == '>') {
				if(node.right != null) {
					node = node.right;
				}
			} else {
				node.add(c);
			}
		}

		return head;
	}

	static void printPassword(Node node) {
		StringBuilder sb = new StringBuilder();
		while(node.right.val != null) {
			sb.append(node.right.val);
			node = node.right;
		}
		System.out.println(sb.toString());
	}

	static class Node {
		Node left, right;
		Character val;

		public Node() {}

		public Node(Character val) {
			this.val = val;
		}

		public void add(Character c) {
			Node node = new Node(c);
			left.right = node;
			node.left = left;
			left = node;
			node.right = this;
		}

		public void backspace() {
			if (left.val != null) {
				left = left.left;
				left.right = this;
			}
		}
	}
}
