package minsun.stackQueue;

class LeetCode_622_DesignCircularQueue {
    int[] circularQ;
    int size = 0;
    int idx = -1;
    public LeetCode_622_DesignCircularQueue(int k) {
        circularQ = new int[k];
    }

    public boolean enQueue(int value) {
        if (size < circularQ.length) {
            size++;
            circularQ[++idx % circularQ.length] = value;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (size > 0) {
            circularQ[(idx - size-- + circularQ.length + 1) % circularQ.length] = 0;
            return true;
        }
        return false;
    }

    public int Front() {
        if (size > 0)
            return circularQ[(idx - size + circularQ.length + 1) % circularQ.length];
        return -1;
    }

    public int Rear() {
        if (size > 0)
            return circularQ[idx % circularQ.length];
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == circularQ.length;
    }
}