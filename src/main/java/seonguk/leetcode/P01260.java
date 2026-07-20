package seonguk.leetcode;

import java.util.*;

public class P01260 {
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int n = grid.length;
            int m = grid[0].length;

            for (int[] nums : grid) {
                for (int num : nums) {
                    dq.addLast(num);
                }
            }

            k %= n * m;
            while(k-- > 0) {
                dq.addFirst(dq.pollLast());
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    temp.add(dq.pollFirst());
                }
                ans.add(temp);
            }

            return ans;
        }
    }
}
