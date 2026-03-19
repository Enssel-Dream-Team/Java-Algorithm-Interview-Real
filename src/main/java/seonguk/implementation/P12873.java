package seonguk.implementation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P12873 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        for (int i = 1; i < N; i++) {
            long cnt = (long) (Math.pow(i, 3) - 1);
            cnt %= (N - i + 1);
            for (int j = 1; j <= cnt; j++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }
        System.out.println(deque.peekFirst());
        scan.close();
    }
}
