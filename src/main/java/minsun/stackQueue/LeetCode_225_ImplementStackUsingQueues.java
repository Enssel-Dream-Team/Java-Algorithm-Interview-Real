package minsun.stackQueue;

import java.util.*;

class LeetCode_225_ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public LeetCode_225_ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        int last = q1.peek();
        while (!q1.isEmpty()){
            int cur = q1.poll();
            if (q1.isEmpty()) last = cur;
            else q2.offer(cur);
        }
        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return last;
    }

    public int top() {
        int last = q1.peek();
        while (!q1.isEmpty()){
            int cur = q1.poll();
            q2.offer(cur);
            if (q1.isEmpty()) last = cur;
        }
        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return last;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */