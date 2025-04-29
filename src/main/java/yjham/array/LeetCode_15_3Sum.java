package yjham.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			int x = nums[i];

			if (x > 0) break;
			if (i > 0 && x == nums[i - 1]) continue;

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = x + nums[left] + nums[right];

				if (sum == 0) {
					result.add(List.of(x, nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1]) left++;
					while (left < right && nums[right] == nums[right - 1]) right--;

					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}
}
