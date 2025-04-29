package jongyeob.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_3Sum {
	static List<List<Integer>> answer;

	public void twoSum(int[] nums, int pivot, int pivotIndex) {
		int left = pivotIndex + 1;
		int right = nums.length - 1;
		int target = pivot * -1;

		int sum;
		while (left < right) {
			sum = nums[left] + nums[right];
			if (sum == target) {
				answer.add(Arrays.asList(pivot, nums[left++], nums[right--]));
				while (left < right && nums[left] == nums[left - 1])
					left++;

			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		answer = new ArrayList<>();

		for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int pivot = nums[i];
			twoSum(nums, pivot, i);
		}
		return answer;
	}
}
