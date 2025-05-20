package jongyeob.stackqueue;

public class LeetCode_622_DesignCircularQueue {
}

class MyCircularQueue {
	int[] queue;
	int head;
	int tail;
	int len;

	public MyCircularQueue(int k) {
		queue = new int[k];
		head = -1;
		tail = -2;
		len = k;
	}

	public boolean enQueue(int value) {
		if(isFull()) return false;
		if(head == -1){
			head = 0;
			tail = 0;
		}
		queue[head] = value;
		head = (head + 1) % len;
		return true;
	}

	public boolean deQueue() {
		if(isEmpty()) return false;
		tail = (tail + 1) % len;
		if(head == tail){
			head = -1;
			tail = -2;
		}
		return true;
	}

	public int Front() {
		if(isEmpty()) return -1;
		return queue[tail];
	}

	public int Rear() {
		if(isEmpty()) return -1;
		return queue[(head - 1 + len) % len];
	}

	public boolean isEmpty() {
		return head == -1 && tail == -2;
	}

	public boolean isFull() {
		return head == tail;
	}
}
