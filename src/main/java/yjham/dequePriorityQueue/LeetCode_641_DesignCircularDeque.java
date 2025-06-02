package yjham.dequePriorityQueue;

public class LeetCode_641_DesignCircularDeque {

    public Object[] useMyCircularDeque(String[] commands, Integer[] inputs) {

        int len = commands.length;

        MyCircularDeque dq = new MyCircularDeque(inputs[0]);

        Object[] answer = new Object[len];

        for(int i = 1; i < len; i++) {
            String cmd = commands[i];
            Integer x = inputs[i];

            switch(cmd) {
                case "insertFront" -> answer[i] = dq.insertFront(x);
                case "insertLast" -> answer[i] = dq.insertLast(x);
                case "deleteFront" -> answer[i] = dq.deleteFront();
                case "deleteLast" -> answer[i] = dq.deleteLast();
                case "getFront" -> answer[i] = dq.getFront();
                case "getRear" -> answer[i] = dq.getRear();
                case "isEmpty" -> answer[i] = dq.isEmpty();
                case "isFull" -> answer[i] = dq.isFull();
                default -> answer[i] = null;
            }
        }

        return answer;
    }

}

class MyCircularDeque {
    int[] dq;
    int front;
    int rear;
    int capacity;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        dq = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        dq[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        dq[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return dq[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return dq[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
