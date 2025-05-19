package yjham.stackQueue;

import java.util.ArrayDeque;
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

    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        int size = q.size();

        q.offer(x);

        for (int i = 0; i < size; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.isEmpty() ? 0 : q.poll();
    }

    public int top() {
        return q.isEmpty() ? 0 : q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}