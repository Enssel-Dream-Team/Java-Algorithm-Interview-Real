package hyeongil.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {

		// 1. 크기순으로 탐색하기 위해 정렬을 수행한다.
		Arrays.sort(nums);

		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {

			// 하나의 수를 고정시키고
			int fixedNumber = nums[i];

			// i + 1 ~ end까지의 수 두개를 선택한다.
			// 크기 순으로 정렬되어 있기때문에, 초기에 i+1, length - 1 번째 원소를 선택하고
			// 0보다 작다면, 왼쪽 원소 인덱스를 증가시키고, 0보다 크다면, 오른쪽 원소 인덱스를 감소시킨다.
			int leftIdx = i + 1;
			int rightIdx = nums.length - 1;

			while (leftIdx < rightIdx) {
				int left = nums[leftIdx];
				int right = nums[rightIdx];
				int sum = left + right + fixedNumber;
				if (sum == 0) {
					set.add(List.of(left, right, fixedNumber));
					rightIdx--;
				}

				// 수가 크면,
				if (sum > 0) {
					rightIdx--;
				}

				if (sum < 0) {
					leftIdx++;
				}
			}

		}
		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		System.out.println(new Leetcode_15_3Sum().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}
}