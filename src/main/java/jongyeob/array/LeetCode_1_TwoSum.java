package jongyeob.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[] {2, 7, 11, 15};
		int[] result = twoSum(nums, 9);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numIndices = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int needNum = target - nums[i];
			if (numIndices.containsKey(needNum)) {
				return new int[] {numIndices.get(needNum), i};
			}
			numIndices.put(nums[i], i);
		}
		return new int[0];
	}
}
