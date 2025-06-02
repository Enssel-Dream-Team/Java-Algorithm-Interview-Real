package minsun.stackQueue;

class LeetCode_641_DesignCircularDeque {
    int[] circularQ;
    int front = 0;
    int back = 0;
    int size = 0;
    public LeetCode_641_DesignCircularDeque(int k) {
        circularQ = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        circularQ[front] = value;
        size++;
        front = (circularQ.length + front - 1) % circularQ.length;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (front == back) front = (circularQ.length + front - 1) % circularQ.length;
        else back = (back + 1) % circularQ.length;
        circularQ[(back) % circularQ.length] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        int first = circularQ[(front + 1) % circularQ.length];
        circularQ[(front + 1) % circularQ.length] = 0;
        front = (front + 1) % circularQ.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        int last = circularQ[back % circularQ.length];
        circularQ[back % circularQ.length] = 0;
        back = (circularQ.length + back - 1) % circularQ.length;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return circularQ[(front + 1) % circularQ.length];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return circularQ[back];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == circularQ.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */