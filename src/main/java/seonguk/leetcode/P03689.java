package seonguk.leetcode;

public class P03689 {
    class Solution {
        public long maxTotalValue(int[] nums, int k) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            long ans = (long) (max - min) * k;
            return ans;
        }
    }
}
