package seonguk.deque;

import java.util.*;

public class Programmers_42626_Scoville {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int i = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            if(a < K) {
                int b = pq.poll();
                a = a + 2 * b;
                pq.add(a);
                i++;
            } else {
                answer = i;
                break;
            }
        }
        if(pq.size() == 1 && pq.poll() < K)
            return -1;
        else
            answer = i;

        return answer;
    }
}
