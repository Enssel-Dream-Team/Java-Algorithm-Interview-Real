package hyeongil.stackqueue;

import java.util.Stack;

public class LeetCode_232_ImplementQueueusingStacks {

}

class MyQueue {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> saveStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
    }

    // -> 1 2 3 4 5 ->
    public int pop() {
        while (stack.size() > 1) {
            saveStack.push(stack.pop());
        }
        // 1 2 3 4 5
        int pop = stack.pop(); // 1

        // 5 4 3 2
        while (!saveStack.isEmpty()) {
            stack.push(saveStack.pop());
        }
        return pop;
    }

    public int peek() {
        while (stack.size() > 1) {
            saveStack.push(stack.pop());
        }
        // 1 2 3 4 5
        int pop = stack.pop(); // 1

        stack.push(pop);
        // 5 4 3 2
        while (!saveStack.isEmpty()) {
            stack.push(saveStack.pop());
        }

        return pop;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
