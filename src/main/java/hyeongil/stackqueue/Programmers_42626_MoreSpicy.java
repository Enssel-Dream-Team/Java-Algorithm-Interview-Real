package hyeongil.stackqueue;

import java.util.PriorityQueue;

/**
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
 * 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 *
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * -> 전체 음식 중 작은 스코빌 지수를 가지는 2개의 원소를 항상 꺼낼 수 있어야한다.
 * -> Priority Queue
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * -> 꺼냈는데 가장 작은 스코빌 지수가 k 이상이면 끝난다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * -> 다 섞고 난 뒤의 횟수
 *
 * 제한 사항
 * scoville의 길이는 2 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */
public class Programmers_42626_MoreSpicy {
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        // 가장 작은 스코빌 지수가, K보다 작을 때까지
        while (pq.peek() < K) {
            Integer first = pq.poll(); // 첫 번째로 작을 경우
            Integer second = pq.poll(); // 두 번째로 작을 경우
            pq.offer(first + second * 2);
            result++;
        }

        return result;
    }
}
