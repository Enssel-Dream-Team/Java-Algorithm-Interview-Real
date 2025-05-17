package seonguk.stackQueue;

public class LeetCode_622_DesignCircularQueue {
    static class MyCircularQueue {
        Integer[] arr;
        int max;
        int headIdx = 0;
        int tailIdx = 0;

        private int nextIdx(int idx) {
            if(idx < max - 1)
                return idx + 1;
            else
                return 0;
        }

        public MyCircularQueue(int k) {
            arr = new Integer[k];
            max = k;
        }

        public boolean enQueue(int value) {
            if(arr[tailIdx] == null) {
                arr[tailIdx] = value;
                tailIdx = nextIdx(tailIdx);
                return true;
            } else {
                return false;
            }
        }

        public boolean deQueue() {
            if(arr[headIdx] != null) {
                arr[headIdx] = null;
                headIdx = nextIdx(headIdx);
                return true;
            } else {
                return false;
            }
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return arr[headIdx];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            if (tailIdx == 0)
                return arr[max - 1];
            else
                return arr[tailIdx - 1];
        }

        public boolean isEmpty() {
            return arr[headIdx] == null;
        }

        public boolean isFull() {
            return arr[tailIdx] != null;
        }
    }
}
