package jongyeob.x06Que;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Card2_2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = solve(N);
        System.out.println(result);
    }

    private static int solve(int n) {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            que.add(i + 1);
        }
        while (que.size() != 1) {
            que.poll();
            que.add(que.poll());
        }
        return que.peek();
    }
}
