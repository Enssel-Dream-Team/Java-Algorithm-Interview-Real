package jongyeob.stackqueue;

import java.util.Stack;

public class LeetCode_232_ImplementQueueUsingStacks {
	public Object[] useMyQueue(String[] commands, Integer[] input) {

		int len = commands.length;

		MyQueue q = new MyQueue();
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
				case "peek" -> {
					int val = q.peek();
					output[i] = val == 0 ? null : val;
				}
				case "empty" -> output[i] = q.empty();
			}
		}

		return output;
	}

}

class MyQueue {
	Stack<Integer> stack;
	Stack<Integer> temp;
	public MyQueue() {
		stack = new Stack<>();
		temp = new Stack<>();
	}

	public void push(int x) {
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		stack.push(x);
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}

	}

	public int pop() {
		return stack.pop();
	}

	public int peek(){
		return stack.peek();
	}

	public boolean empty(){
		return stack.isEmpty();
	}
}
