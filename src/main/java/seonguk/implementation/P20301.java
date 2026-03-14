package seonguk.implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class P20301 {

    public static void main(String[] args) throws IOException {
        Scanner scan =  new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(scan.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ReverseJosephus josephus = new ReverseJosephus(N, K, M);
        for (int i = 0; i < N; i++) {
            bw.write(josephus.delete() + "\n");
        }
        bw.flush();
        bw.close();
        scan.close();
    }

    static class ReverseJosephus {
        Deque<Integer> deque;
        boolean isForward;
        int K, M;
        int cnt;

        public ReverseJosephus(int N, int K, int M) {
            this.K = K;
            this.M = M;
            this.cnt = 0;

            deque = new LinkedList<>();
            isForward = true;

            for (int i = 1; i <= N; i++) {
                deque.addLast(i);
            }
        }

        public int delete() {
            if (cnt == M) {
                isForward = !isForward;
                cnt = 0;
            }

            if (isForward) {
                for (int i = 0; i < K - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
                cnt++;
                return deque.pollFirst();
            } else {
                for (int i = 0; i < K - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
                cnt++;
                return deque.pollLast();
            }
        }
    }
}
