package yjham.dequePriorityQueue;

import java.util.PriorityQueue;

public class Programmers_42626_Scoville {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int s : scoville) q.offer(s);

        int cnt = 0;

        while(!q.isEmpty()) {
            int first = q.poll();

            if(first >= K) break;
            if(q.isEmpty()) return -1;

            cnt++;

            q.offer(first + (q.poll() * 2));
        }

        return cnt;
    }
}
