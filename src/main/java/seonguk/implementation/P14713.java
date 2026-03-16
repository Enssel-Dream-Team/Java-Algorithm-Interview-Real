package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P14713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String>[] arr = new ArrayDeque[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayDeque<>();
            String[] strArr = br.readLine().split(" ");
            for (String s : strArr) {
                arr[i].addLast(s);
            }
        }

        String[] result = br.readLine().split(" ");
        for (String s : result) {
            boolean flag = true;
            for (Deque<String> deque : arr) {
                if (!deque.isEmpty() && s.equals(deque.peekFirst())) {
                    deque.removeFirst();
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("Impossible");
                return;
            }
        }

        for (Deque<String> deque : arr) {
            if (!deque.isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

}
