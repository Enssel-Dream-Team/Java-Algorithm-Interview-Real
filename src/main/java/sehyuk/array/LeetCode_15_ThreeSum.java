package sehyuk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15. 3sum
 *  Link : https://leetcode.com/problems/3sum/description/
 *  explanation :
 *  1. 먼저 배열을 정렬한다.
 *  2. 시작점을 잡고 투 포인터를 이용하여 0이 나오는 경우의 수를 탐색한다.
 *  3. 0이 나오는 경우의 수를 찾았을 경우, 중복을 예방하기 위해 right 값이 이전에 탐색한 적이 있는 값인지 체크한다.
 *
 **/

public class LeetCode_15_ThreeSum {
	public static void main(String[] args){
		int[] arr={-1,0,1,2,-1,-4};
		threeSum(arr);
	}
	public static List<List<Integer>> threeSum(int[] arr) {
		return threeSum(arr, 0);
	}

	public static List<List<Integer>> threeSum(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-2; i++) {
			int rest = target - arr[i];
			if(i > 0 && arr[i] == arr[i - 1]){  // 시작 값이 어전과 동일하다면
				continue;
			}
			if(arr[i]>0){  // 시작 값이 0 이상이라면
				break;
			}
			int left = i + 1, right = arr.length - 1;

			while(left < right){
				if(arr[left] + arr[right] < rest){
					left++;
				}else if(arr[left] + arr[right] > rest){
					right--;
				}else{
					if(right == arr.length - 1 || arr[right] != arr[right + 1]){
						ans.add(Arrays.asList(arr[i],arr[left], arr[right] ));
					}
					left++;
					right--;

				}
			}
		}
		return ans;
	}
}
