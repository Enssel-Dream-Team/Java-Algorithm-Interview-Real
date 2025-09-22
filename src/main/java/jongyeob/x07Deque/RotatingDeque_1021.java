package jongyeob.x07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class RotatingDeque_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int[] input = new int[M];
        String[] rawInput = reader.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(rawInput[i]);
        }
        int result = solve(input, N);
        System.out.println(result);
    }

    private static int solve(int[] inputs, int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            deque.addLast(i);
        }
        int count = 0;
        for (int input : inputs) {
            int targetIndex = getTargetIndex(deque, input);
            int backLoopCount = Math.abs(deque.size() - targetIndex);
            if (backLoopCount >= targetIndex) {
                for (int i = 0; i < targetIndex; i++)
                    deque.addLast(deque.pollFirst());
                count += targetIndex;
            } else {
                for (int i = 0; i < backLoopCount; i++) {
                    deque.addFirst(deque.pollLast());
                }
                count += backLoopCount;
            }
            deque.pollFirst();
        }
        return count;
    }

    private static int getTargetIndex(Deque<Integer> deque, int target) {
        Deque<Integer> copy = new ArrayDeque<>(deque);
        int index = 0;
        while (copy.peekFirst() != target) {
            index++;
            copy.pollFirst();
        }
        return index;
    }
}
