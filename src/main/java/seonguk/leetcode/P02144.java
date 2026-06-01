package seonguk.leetcode;

import java.util.*;

public class P02144 {
    class Solution {
        public int minimumCost(int[] cost) {
            Arrays.sort(cost);

            int n = cost.length;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    continue;
                }
                ans += cost[n - i];
            }

            return ans;
        }
    }
}
