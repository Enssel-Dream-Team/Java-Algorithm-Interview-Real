package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P13417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            deque.addLast(st.nextToken());
            for (int i = 1; i < N; i++) {
                String str = st.nextToken();
                if (deque.peekFirst().compareTo(str) >= 0) {
                    deque.addFirst(str);
                } else {
                    deque.addLast(str);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
