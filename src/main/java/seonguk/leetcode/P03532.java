package seonguk.leetcode;

import java.util.*;

public class P03532 {

    class Solution {

        static List<Integer> blockList;

        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            blockList = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if(nums[i] - nums[i - 1] <= maxDiff) {
                    continue;
                }
                blockList.add(i);
            }

            int m = queries.length;
            boolean[] ans = new boolean[m];

            if (blockList.size() == 0) {
                Arrays.fill(ans, true);
                return ans;
            }

            int size = blockList.size();
            for (int i = 0; i < m; i++) {
                int[] query = queries[i];
                int min = Math.min(query[0], query[1]);
                int max = Math.max(query[0], query[1]);

                int idx = binarySearch(0, size, min);
                int val = blockList.get(idx);

                if (min < val && val <= max) {
                    ans[i] = false;
                    continue;
                }
                if (idx + 1 < size && blockList.get(idx + 1) <= max) {
                    ans[i] = false;
                    continue;
                }
                ans[i] = true;
            }

            return ans;
        }

        static int binarySearch(int min, int max, int target) {
            int mid = (min + max) / 2;
            if (mid == min) {
                return mid;
            }

            int val = blockList.get(mid);
            if (val < target) {
                return binarySearch(mid, max, target);
            } else if (val > target) {
                return binarySearch(min, mid, target);
            }

            return mid;
        }
    }
}
