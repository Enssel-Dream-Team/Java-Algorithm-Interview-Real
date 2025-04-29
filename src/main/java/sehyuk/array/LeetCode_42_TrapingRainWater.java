package sehyuk.array;


/**
 *  42. Trapping Rain Water
 *  Link : https://leetcode.com/problems/trapping-rain-water/description/
 *  explanation :
 *  1. 시작점을 찾는다.
 *  2. while문으로 순회하면서 다음 나보다 높은 벽을 찾는다.
 *  3. 시작점과 나보다 높은 벽 사이의 물의 양을 측정한다.
 *  4. 나보다 높은 벽을 다시 시작점으로 잡고 2~3번을 반복한다.
 *
 **/

public class LeetCode_42_TrapingRainWater{
	public static void main(String[] args){
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		trap(height);
	}
	public static int trap(int[] height) {
		int total = 0;
		int searchIdx = searchinitIdx(height, 0);
		if (searchIdx == -1) {
			return 0;
		}

		while (searchIdx != -1 && searchIdx < height.length) {
			int startIdx = searchIdx;
			int nextIdx = findNextIdx(height, startIdx);

			if (nextIdx == -1) {
				break;
			}

			int minHeight = Math.min(height[startIdx], height[nextIdx]);
			for (int i = startIdx + 1; i < nextIdx; i++) {
				total += minHeight - height[i];
			}

			searchIdx = nextIdx;
		}

		return total;
	}

	public static int searchinitIdx(int[] height, int startIdx) {
		for (int i = startIdx; i < height.length; i++) {
			if (height[i] > 0) {
				return i;
			}
		}
		return -1;
	}

	public static int findNextIdx(int[] height, int startIdx) {
		int maxIdx = -1;
		int maxHeight = 0;
		for (int i = startIdx + 1; i < height.length; i++) {
			if (height[i] >= height[startIdx]) {
				return i;
			}
			if (height[i] > maxHeight) {
				maxHeight = height[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
}
