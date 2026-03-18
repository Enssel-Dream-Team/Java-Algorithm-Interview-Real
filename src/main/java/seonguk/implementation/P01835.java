package seonguk.implementation;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P01835 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Deque<Integer> deck = new ArrayDeque<>();
        do {
            deck.addFirst(N);
            shuffle(deck, N);
        } while (--N > 0);

        StringBuilder sb = new StringBuilder();
        while (!deck.isEmpty()) {
            sb.append(deck.pollFirst()).append(" ");
        }
        System.out.println(sb);
        scan.close();
    }

    static void shuffle(Deque<Integer> deck, int n) {
        for (int i = 0; i < n; i++) {
            deck.addFirst(deck.pollLast());
        }
    }

}
