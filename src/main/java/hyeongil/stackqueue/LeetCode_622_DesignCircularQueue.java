package hyeongil.stackqueue;

public class LeetCode_622_DesignCircularQueue {

}

class MyCircularQueue {
    int queue[];
    int front;
    int rear;
    int len;
    // queue는 LIFO 자료구조, front가 가르키는 원소를 반환
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = -1;
        len = 0;
    }

    public boolean enQueue(int value) {
        //
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % queue.length;
        len--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return queue[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == queue.length;
    }
}