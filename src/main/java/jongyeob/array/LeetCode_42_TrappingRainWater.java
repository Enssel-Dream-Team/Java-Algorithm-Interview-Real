package jongyeob.array;

public class LeetCode_42_TrappingRainWater {
	public static int trap(int[] height) {
		if (height.length == 0)
			return 0;

		int water = 0;
		int left = 0;
		int right = height.length - 1;
		int leftHighest = height[left];
		int rightHighest = height[right];

		while (left < right) {
			leftHighest = Math.max(height[left], leftHighest);
			rightHighest = Math.max(height[right], rightHighest);

			if (leftHighest <= rightHighest) {
				water += leftHighest - height[left];
				left += 1;
			} else {
				water += rightHighest - height[right];
				right -= 1;
			}
		}

		return water;
	}

	public static void main(String[] args) {
		int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println("trap(height) = " + trap(height));
	}
}
