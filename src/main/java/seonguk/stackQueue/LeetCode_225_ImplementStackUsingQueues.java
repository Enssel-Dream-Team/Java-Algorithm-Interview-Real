package seonguk.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225_ImplementStackUsingQueues {
    static class MyStack {
        Queue<Integer> mainQue;
        Queue<Integer> subQue;

        public MyStack() {
            this.mainQue = new LinkedList<>();
            this.subQue = new LinkedList<>();
        }

        public void push(int x) {
            mainQue.add(x);
        }

        public int pop() {
            int size = mainQue.size();
            for(int i = 0; i < size - 1; i++) {
                subQue.add(mainQue.poll());
            }
            int ans = mainQue.poll();
            mainQue = subQue;
            subQue = new LinkedList<>();

            return ans;
        }

        public int top() {
            int ans = pop();
            mainQue.add(ans);
            return ans;
        }

        public boolean empty() {
            return mainQue.isEmpty();
        }
    }
}
