package seonguk.leetcode;

public class P01752 {
    class Solution {
        public boolean check(int[] nums) {
            int zeroIdxVal = nums[0];
            int val = nums[0];

            int i = 1;
            for (; i < nums.length; i++) {
                if (val <= nums[i]) {
                    val = nums[i];
                } else {
                    break;
                }
            }

            if (i == nums.length) {
                return true;
            }

            if (nums[i] > zeroIdxVal) {
                return false;
            }

            val = nums[i++];
            for (; i < nums.length; i++) {
                if (val <= nums[i] && val <= zeroIdxVal) {
                    val = nums[i];
                } else {
                    return false;
                }
            }

            if (nums[i - 1] > zeroIdxVal) {
                return false;
            }

            return true;
        }
    }
}
