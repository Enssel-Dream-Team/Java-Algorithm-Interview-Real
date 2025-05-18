package seonguk.stackQueue;

import java.util.Stack;

public class LeetCode_232_ImplementQueueUsingStacks {
    static class MyQueue {
        Stack<Integer> mainStack;
        Stack<Integer> subStack;

        public MyQueue() {
            mainStack = new Stack<>();
            subStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
        }

        public int pop() {
            int size = mainStack.size();
            for(int i = 0; i < size - 1; i++)
                subStack.push(mainStack.pop());

            int ans = mainStack.pop();
            for(int i = 0; i < size - 1; i++)
                mainStack.push(subStack.pop());

            return ans;
        }

        public int peek() {
            int size = mainStack.size();
            for(int i = 0; i < size - 1; i++)
                subStack.push(mainStack.pop());

            int ans = mainStack.pop();
            mainStack.add(ans);

            for(int i = 0; i < size - 1; i++)
                mainStack.push(subStack.pop());

            return ans;
        }

        public boolean empty() {
            return mainStack.isEmpty();
        }
    }
}
