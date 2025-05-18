package hyeongil.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LeetCode_225_ImplementStackusingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());



    }
}

// Queue ->
class MyStack {
    Queue<Integer> queue = new ArrayDeque<>();
    Queue<Integer> saveQueue = new ArrayDeque<>();
    // queue -> FIFO
    // offer -> 5 4 3 2 1
    // ? -> 1 2 3 4 5
    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            saveQueue.offer(queue.poll());
        }
        Integer polled = queue.poll();
        while(!saveQueue.isEmpty()) {
            queue.offer(saveQueue.poll());
        }
        return polled;
    }

    public int top() {
        while (queue.size() > 1) {
            saveQueue.offer(queue.poll());
        }
        Integer polled = queue.poll();
        while(!saveQueue.isEmpty()) {
            queue.offer(saveQueue.poll());
        }
        queue.offer(polled);
        return polled;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

