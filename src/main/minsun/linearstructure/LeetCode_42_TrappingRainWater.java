package array;

public class LeetCode_42_TrappingRainWater {
	public int trap(int[] height) {
		int s = 0;
		int e = 0;

		int answer = 0;

		int sum = 0;
		while (e < height.length){
			if (height[e] < height[s]){
				sum += height[s] - height[e];
			} else {
				answer += sum;
				sum = 0;
				s = e;
			}
			e++;
		}

		s = height.length - 1;
		e = height.length - 1;
		sum = 0;

		while (e >= 0){
			if (height[e] <= height[s]){
				sum += height[s] - height[e];
			} else {
				answer += sum;
				sum = 0;
				s = e;
			}


			e--;
		}

		return answer;
	}
}