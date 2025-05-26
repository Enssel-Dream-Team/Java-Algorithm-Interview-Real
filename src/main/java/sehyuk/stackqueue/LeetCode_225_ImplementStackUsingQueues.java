package sehyuk.stackqueue;

public class LeetCode_225_ImplementStackUsingQueues {
	class MyStack {
		int[] list;
		int head;

		public MyStack() {
			list=new int[10];
			head = 0;
		}

		public void push(int x) {
			list[head] = x;
			head++;
		}

		public int pop() {
			int num= list[--head];
			return num;
		}

		public int top() {
			return list[head-1];
		}

		public boolean empty() {
			return head==0 ? true : false;
		}
	}
}
