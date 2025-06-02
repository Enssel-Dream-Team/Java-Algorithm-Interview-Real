package minsun.stackQueue;

import java.util.*;

class 프로그래머스_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s:scoville){
            pq.offer(s);
        }
        int answer = 0;
        while (pq.peek() < K){
            int smallest = pq.poll();
            if (pq.isEmpty()){
                return -1;
            }
            int secondSmallest = pq.poll();
            int newS = smallest + secondSmallest * 2;
            pq.offer(newS);
            answer++;
        }

        return answer;
    }
}