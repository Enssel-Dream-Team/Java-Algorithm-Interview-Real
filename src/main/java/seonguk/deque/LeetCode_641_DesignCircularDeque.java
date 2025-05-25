package seonguk.deque;

public class LeetCode_641_DesignCircularDeque {
    static class MyCircularDeque {
        Integer[] deque;
        int frontIdx, lastIdx;
        final int MAX_VAL;

        public MyCircularDeque(int k) {
            deque = new Integer[k];
            MAX_VAL = k;
        }

        public boolean insertFront(int value) {
            int nextIdx;
            if(frontIdx == 0)
                nextIdx = MAX_VAL - 1;
            else
                nextIdx = frontIdx - 1;

            if(deque[nextIdx] != null)
                return false;

            deque[nextIdx] = value;
            frontIdx = nextIdx;
            return true;
        }

        public boolean insertLast(int value) {
            if(deque[lastIdx] != null)
                return false;

            deque[lastIdx] = value;
            if(lastIdx == MAX_VAL - 1)
                lastIdx = 0;
            else
                lastIdx += 1;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty())
                return false;

            deque[frontIdx] = null;
            if(frontIdx == MAX_VAL - 1)
                frontIdx = 0;
            else
                frontIdx += 1;

            return true;
        }

        public boolean deleteLast() {
            if(isEmpty())
                return false;

            int nextIdx;
            if(lastIdx == 0)
                nextIdx = MAX_VAL - 1;
            else
                nextIdx = lastIdx - 1;
            deque[nextIdx] = null;
            lastIdx = nextIdx;
            return true;
        }

        public int getFront() {
            if(isEmpty())
                return -1;
            return deque[frontIdx];
        }

        public int getRear() {
            if(isEmpty())
                return -1;
            if(lastIdx == 0)
                return deque[MAX_VAL - 1];
            return deque[lastIdx - 1];
        }

        public boolean isEmpty() {
            return deque[frontIdx] == null;
        }

        public boolean isFull() {
            return !isEmpty() && frontIdx == lastIdx;
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
}
