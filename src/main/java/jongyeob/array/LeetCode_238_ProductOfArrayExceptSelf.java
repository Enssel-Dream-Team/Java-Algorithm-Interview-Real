package jongyeob.array;

public class LeetCode_238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int left = 1;
		int right = 1;
		int[] answer = new int[nums.length];
		int[] leftProduct = new int[nums.length];
		int[] rightProduct = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			leftProduct[i] = left;
			left *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			rightProduct[i] = right;
			right *= nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			answer[i] = leftProduct[i] * rightProduct[i];
		}

		return answer;
	}
}
