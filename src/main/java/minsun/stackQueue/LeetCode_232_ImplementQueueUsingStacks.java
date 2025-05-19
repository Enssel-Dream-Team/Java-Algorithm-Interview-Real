package minsun.stackQueue;

import java.util.*;

class LeetCode_232_ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public LeetCode_232_ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int first = stack1.peek();
        while (!stack1.isEmpty()){
            first = stack1.pop();
            if (!stack1.isEmpty())stack2.push(first);
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public int peek() {
        int first = stack1.peek();
        while (!stack1.isEmpty()){
            first = stack1.pop();
            stack2.push(first);
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */