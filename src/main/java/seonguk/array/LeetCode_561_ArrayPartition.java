package seonguk.array;

import java.util.Arrays;

public class LeetCode_561_ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for(int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }
}
