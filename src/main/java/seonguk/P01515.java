package seonguk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01515 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Character> queue = new ArrayDeque<>();
        scan.nextLine().chars().forEach(c -> queue.addLast((char) c));

        int ans = 0;

        while (!queue.isEmpty()) {
            ans++;
            Deque<Character> temp = new ArrayDeque<>();
            String.valueOf(ans).chars().forEach(c -> temp.addLast((char) c));

            while (!temp.isEmpty()) {
                if (queue.isEmpty()) {
                    break;
                }

                char serialChar = temp.pollFirst();
                char inputChar = queue.peekFirst();
                if (serialChar == inputChar) {
                    queue.pollFirst();
                }
            }
        }

        System.out.println(ans);
    }

}
