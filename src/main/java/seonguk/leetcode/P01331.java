package seonguk.leetcode;

import java.util.*;

public class P01331 {
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int key = arr[i];
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                if (list.isEmpty()) {
                    pq.add(key);
                }
                list.add(i);
                map.put(key, list);
            }

            int rank = 1;
            while(!pq.isEmpty()) {
                int key = pq.poll();
                for (int idx : map.get(key)) {
                    ans[idx] = rank;
                }
                rank++;
            }

            return ans;
        }
    }
}
