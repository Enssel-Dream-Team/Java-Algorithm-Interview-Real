package seonguk.array;

public class LeetCode_1_TowSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        loop:
        for(int i = 0; i < nums.length - 1; i++) {
            int remain = target - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == remain) {
                    ans[0] = i;
                    ans[1] = j;
                    break loop;
                }
            }
        }
        return ans;
    }
}
