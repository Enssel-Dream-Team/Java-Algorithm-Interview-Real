package seonguk.leetcode;

import java.util.*;

public class P02685 {

    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            int[] vertices = new int[n];
            List<List<Integer>> graphs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graphs.add(new ArrayList<Integer>());
            }

            for (int[] edge : edges) {
                int n1 = edge[0];
                int n2 = edge[1];
                graphs.get(n1).add(n2);
                graphs.get(n2).add(n1);
                vertices[n1]++;
                vertices[n2]++;
            }

            boolean[] visited = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (vertices[i] == 0) {
                    ans++;
                    continue;
                }
                if (visited[i]) {
                    continue;
                }

                if (checkComplete(graphs, vertices, i, visited)) {
                    ans++;
                }
            }
            return ans;
        }

        static boolean checkComplete(List<List<Integer>> graphs, int[] vertices, int i, boolean[] visited) {
            Deque<Integer> dq = new LinkedList<>();
            dq.addLast(i);
            visited[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(i);

            while(!dq.isEmpty()) {
                int idx = dq.pollFirst();
                List<Integer> graph = graphs.get(idx);
                for (int num : graph) {
                    if (!visited[num]) {
                        visited[num] = true;
                        dq.addLast(num);
                        list.add(num);
                    }
                }
            }

            int cnt = list.size();
            int link = 0;
            for (int idx : list) {
                link += vertices[idx];
            }
            link /= 2;
            return cnt * (cnt - 1) / 2 == link;
        }
    }
}
