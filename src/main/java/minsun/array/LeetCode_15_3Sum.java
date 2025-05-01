package array;

import java.util.*;

class LeetCode_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length - 2;i++){
            int first = nums[i];

            if (i > 0 && first == nums[i - 1]) continue;

            int s = i + 1;
            int e = nums.length - 1;

            int target = -first;

            while (s < e){
                int second = nums[s];
                int third = nums[e];


                if (second + third == target){
                    answer.add(Arrays.asList(first, second, third));

                    while (s < nums.length - 1 && nums[s + 1] == second) s++;
                    while (e > 0 && nums[e - 1] == third) e--;

                    s++;
                    e--;
                } else if (second + third > target) e--;
                else s++;
            }
        }

        return answer;
    }
}