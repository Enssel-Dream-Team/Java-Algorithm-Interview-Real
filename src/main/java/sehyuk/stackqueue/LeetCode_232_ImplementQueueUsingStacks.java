package sehyuk.stackqueue;

public class LeetCode_232_ImplementQueueUsingStacks {
	class MyQueue {
		int[] list;
		int front;
		int end;
		public MyQueue() {
			list=new int[10];
			front=-1;
			end=-1;
		}

		public void push(int x) {
			end++;
			list[end]=x;
		}

		public int pop() {
			front++;
			return list[front];
		}

		public int peek() {
			return list[front+1];
		}

		public boolean empty() {
			return front == end ? true: false;
		}
	}
}
