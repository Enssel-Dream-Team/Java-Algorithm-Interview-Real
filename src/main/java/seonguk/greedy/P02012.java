package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P02012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] ranks = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            int rank = Integer.parseInt(br.readLine());
            if (rank <= N && !ranks[rank]) {
                ranks[rank] = true;
                continue;
            }
            pq.add(rank);
        }

        long ans = 0;
        if (!pq.isEmpty()) {
            int rank = pq.poll();

            for (int i = 1; i <= N; i++) {
                if (!ranks[i]) {
                    ans += Math.abs(rank - i);
                    if (!pq.isEmpty()) {
                        rank = pq.poll();
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
