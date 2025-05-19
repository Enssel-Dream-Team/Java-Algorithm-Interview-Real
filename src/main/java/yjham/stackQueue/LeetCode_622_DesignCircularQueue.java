package yjham.stackQueue;

public class LeetCode_622_DesignCircularQueue {

	public Object[] useMyCircularQueue(String[] commands, Integer[] inputs) {
		int len = commands.length;
		Object[] answer = new Object[len];

		MyCircularQueue q = new MyCircularQueue(inputs[0]);

		for(int i = 1; i < len; i++) {
			String cmd = commands[i];
			Integer x = inputs[i];

			switch(cmd) {
				case "enQueue" -> answer[i] = q.enQueue(x);
				case "deQueue" -> {
					answer[i] = q.deQueue();
				}
				case "Front" -> {
					answer[i] = q.Front();
				}
				case "Rear" -> {
					answer[i] = q.Rear();
				}
				case "isEmpty" -> {
					answer[i] = q.isEmpty();
				}
				case "isFull" -> {
					answer[i] = q.isFull();
				}
			}
		}

		return answer;
	}
}

class MyCircularQueue {

	Integer[] q;
	int front;
	int back;

	public MyCircularQueue(int k) {
		q = new Integer[k];
		front = 0;
		back = 0;
	}

	public boolean enQueue(int value) {
		if (isFull()) return false;
		q[back++] = value;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) return false;

		for (int i = 0; i < back - 1; i++) {
			q[i] = q[i + 1];
		}

		back--;

		return true;
	}

	public int Front() {
		return isEmpty() ? -1 : q[front];
	}

	public int Rear() {
		return isEmpty() ? -1 : q[back - 1];
	}

	public boolean isEmpty() {
		return front == back;
	}

	public boolean isFull() {
		return back == q.length;
	}
}