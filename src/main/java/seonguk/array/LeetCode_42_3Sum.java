package seonguk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_42_3Sum {
    static int[] nums;
    public List<List<Integer>> threeSum(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;

        for(int i = 0; i < len - 2; i++) {
            if((i > 0  && nums[i - 1] == nums[i]))
                continue;

            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;

                int target = -1 * (nums[i] + nums[j]);
                int k = binarySearch(j + 1, len - 1, target);
                if (k != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    static int binarySearch(int min, int max, int target) {
        int mid = (min + max) / 2;
        if(nums[mid] == target)
            return mid;
        if(mid < max) {
            if(nums[mid] < target)
                return binarySearch(mid + 1, max, target);
            else
                return binarySearch(min, mid, target);
        } else {
            return -1;
        }
    }
}
