package jongyeob.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225_ImplementStackUsingQueues {
	public Object[] useMyStack(String[] commands, Integer[] input) {

		int len = commands.length;

		MyStack q = new MyStack();
		Object[] output = new Object[len];
		output[0] = null;

		for (int i = 1; i < len; i++) {
			String cmd = commands[i];
			Integer x = input[i];

			switch (cmd) {
				case "push" -> q.push(x);
				case "pop" -> {
					int val = q.pop();
					output[i] = val == 0 ? null : val;
				}
				case "top" -> {
					int val = q.top();
					output[i] = val == 0 ? null : val;
				}
				case "empty" -> output[i] = q.empty();
			}
		}

		return output;
	}

}
class MyStack {
	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.add(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.add(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}
