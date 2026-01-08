package jongyeob.programers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
        int K = 7;
        Solution solution = new Solution();
        int result = solution.solution(scoville, K);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(Long.valueOf(i));
        }
        int answer = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                break;
            }
            Long first = pq.poll();
            Long second = pq.poll();
            long mixedValue = first + (second * 2);
            pq.add(mixedValue);
            answer++;
        }
        if (pq.peek() < K)
            return -1;
        return answer;
    }
}
