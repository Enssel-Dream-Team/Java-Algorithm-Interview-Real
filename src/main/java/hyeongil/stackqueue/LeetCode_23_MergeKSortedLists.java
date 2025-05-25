package hyeongil.stackqueue;

import hyeongil.linkedlist.ListNode;
import java.util.PriorityQueue;

public class LeetCode_23_MergeKSortedLists {
    // 모든 데이터를 순회하는 데 걸리는 비용: 1,000,000
    // O(N^2): 절대로 해결 불가능
    // O(NlogN)로 해결을 해야한다.
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 모든 숫자를 정렬해서 저장한 뒤, ListNode로 생성한다.
        // 시작 이전에, 숫자를 알 수가 없다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            // list안에 있는 모든 노드를 순회.
            while (node != null) {
                int val = node.val;
                // 어떤 자료구조에 저장을 해야 정렬을 수행해서 작은 값부터 꺼낼 수 있을까
                // -> 우선순위 큐를 사용.
                pq.offer(val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        // 큐에 있는 모든 숫자를 꺼낸다.
        while (!pq.isEmpty()) {
            point.next = new ListNode(pq.poll());
            point = point.next;
        }
        return dummy.next;
    }
}
