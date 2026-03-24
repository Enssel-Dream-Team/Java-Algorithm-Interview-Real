package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P02812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Character> right = new LinkedList<>();
        for (char c : br.readLine().toCharArray()) {
            right.addLast(c);
        }
        Deque<Character> left = new LinkedList<>();

        while (K > 0 && !right.isEmpty()) {
            if (left.isEmpty()) {
                left.addLast(right.removeFirst());
                continue;
            }

            if (left.peekLast() < right.peekFirst()) {
                left.removeLast();
                K--;
                continue;
            }

            left.addLast(right.removeFirst());
        }

        while (!right.isEmpty()) {
            left.addLast(right.removeFirst());
        }

        while (K-- > 0) {
            left.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.removeFirst());
        }
        System.out.println(sb);
        br.close();
    }
}
