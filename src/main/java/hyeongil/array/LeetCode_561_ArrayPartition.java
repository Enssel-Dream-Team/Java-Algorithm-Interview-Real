package hyeongil.array;

import java.util.Arrays;

class LeetCode_561_ArrayPartition {
    public int arrayPairSum(int[] nums) {
        // 2개의 숫자를 그룹화하여, 그 그룹 중 작은 값들의 합을 최대로 만드는 문제.
        // 되는 대로, 작은 수들 끼리 그룹화를 하면 문제를 해결할 수 있을 것 같다.
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
