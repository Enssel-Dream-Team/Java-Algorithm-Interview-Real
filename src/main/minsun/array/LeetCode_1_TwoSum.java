package array;

import java.util.*;

class LeetCode_1_TwoSum {
	static class Num {
		int idx;
		int num;

		Num (int idx, int num){
			this.idx = idx;
			this.num = num;
		}
	}
	public int[] twoSum(int[] nums, int target) {
		Num[] numList = new Num[nums.length];
		int idx = 0;
		for (int num: nums){
			numList[idx] = new Num(idx++, num);
		}
		Arrays.sort(numList, (a, b) -> Integer.compare(a.num, b.num));
		int s = 0;
		int e = nums.length - 1;

		while (s < e){
			int first = numList[s].num;
			int second = numList[e].num;

			if (first + second == target){
				return new int[]{numList[s].idx, numList[e].idx};
			} else if (first + second > target) e--;
			else s++;
		}

		return new int[]{s, e};
	}
}