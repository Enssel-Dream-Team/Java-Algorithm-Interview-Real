package yjham.stackQueue;

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

	class MyQueue {

		Stack<Integer> front;
		Stack<Integer> back;

		public MyQueue() {
			front = new Stack<>();
			back = new Stack<>();
		}

		public void push(int x) {
			back.push(x);
		}

		public int pop() {
			if (!front.isEmpty()) {
				return front.pop();
			}

			if (!back.isEmpty()) {
				while (!back.isEmpty()) {
					front.push(back.pop());
				}

				return front.pop();
			}

			return 0;
		}

		public int peek() {
			if (!front.isEmpty()) {
				return front.peek();
			}

			if (!back.isEmpty()) {
				while (!back.isEmpty()) {
					front.push(back.pop());
				}

				return front.peek();
			}

			return 0;
		}

		public boolean empty() {
			return front.empty() && back.empty();
		}
	}
}
