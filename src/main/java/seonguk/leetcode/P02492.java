package seonguk.leetcode;

import java.util.*;

public class P02492 {
    class Solution {
        public int minScore(int n, int[][] roads) {
            Map<Integer, List<Node>> map = new HashMap<>();
            int len = roads.length;
            for (int i = 0; i < len; i++) {
                int[] road = roads[i];
                addRoad(map, road[0], road[1], road[2], i);
                addRoad(map, road[1], road[0], road[2], i);
            }

            boolean[] visited = new boolean[len];
            Deque<Integer> dq = new LinkedList<>();
            dq.addLast(1);

            int ans = Integer.MAX_VALUE;
            while(!dq.isEmpty()) {
                int now = dq.poll();
                for(Node next : map.get(now)) {
                    if (visited[next.idx]) {
                        continue;
                    }

                    ans = Math.min(ans, next.cost);
                    dq.addLast(next.node);
                    visited[next.idx] = true;
                }
            }

            return ans;
        }

        static void addRoad(Map<Integer, List<Node>> map, int from, int to, int cost, int idx) {
            List<Node> list = map.getOrDefault(from, new ArrayList<>());
            list.add(new Node(to, cost, idx));
            map.put(from, list);
        }

        static class Node {
            int node;
            int cost;
            int idx;

            Node(int node, int cost, int idx) {
                this.node = node;
                this.cost = cost;
                this.idx = idx;
            }
        }
    }
}
