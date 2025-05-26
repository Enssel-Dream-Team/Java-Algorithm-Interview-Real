package sehyuk.stackqueue;

public class LeetCode_622_DesignCircularQueue {
	class MyCircularQueue {
		int[] list;
		int front = 0;
		int end = 0;
		int size;

		public MyCircularQueue(int k) {
			list = new int[k + 1];
			size = k + 1;
		}

		public boolean enQueue(int value) {
			if (isFull()) return false;
			list[end] = value;
			end = (end + 1) % size;
			return true;
		}

		public boolean deQueue() {
			if (isEmpty()) return false;
			front = (front + 1) % size;
			return true;
		}

		public int Front() {
			if (isEmpty()) return -1;
			return list[front];
		}

		public int Rear() {
			if (isEmpty()) return -1;
			return list[(end - 1 + size) % size];
		}

		public boolean isEmpty() {
			return front == end;
		}

		public boolean isFull() {
			return (end + 1) % size == front;
		}
	}
}
