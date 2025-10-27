package seonguk.x09bfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class P13913 {

	static Deque<Node> queue;
	static Set<Integer> visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		Node root = new Node(N);
		queue = new LinkedList<>();
		queue.addFirst(root);

		visited = new HashSet<>();
		visited.add(N);

		Node leaf = null;
		while (!queue.isEmpty()) {
			Node node = queue.pollFirst();
			if (node.val == K) {
				leaf = node;
				break;
			}

			int val = node.val;
			add(node, val - 1);
			if (val < K) {
				add(node, val + 1);
				add(node, val * 2);
			}
		}

		Deque<Integer> stack = new LinkedList<>();
		while (leaf.parent != null) {
			stack.push(leaf.val);
			leaf = leaf.parent;
		}
		stack.push(N);

		StringBuilder sb = new StringBuilder();
		sb.append((stack.size() - 1) + "\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);

		scan.close();
	}

	static void add(Node node, int nextVal) {
		if (!visited.contains(nextVal) && nextVal >= 0) {
			visited.add(nextVal);
			Node nextNode = new Node(nextVal, node);
			queue.addLast(nextNode);
		}
	}

	static class Node {
		int val;
		Node parent;

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node parent) {
			this.val = val;
			this.parent = parent;
		}
	}
}
