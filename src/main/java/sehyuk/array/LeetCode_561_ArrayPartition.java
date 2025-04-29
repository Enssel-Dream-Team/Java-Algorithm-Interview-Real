package sehyuk.array;


import java.util.*;
import java.util.stream.*;


/**
 *    561. Array Partition
 *    Link: https://leetcode.com/problems/array-partition/description/
 *    1. 배열을 정렬한다.
 *    2. stream으로 짝수 인덱스 값의 합을 반환한다.
 **/
public class LeetCode_561_ArrayPartition{
	public static void main(String[] args){
		int[] nums= {1,2,3,6,9,7};
		arrayPairSum(nums);
	}


	public static int arrayPairSum(int[] nums) {
		int sum=0;
		Arrays.sort(nums);
		return IntStream.range(0, nums.length)
			.filter(i -> i % 2 == 0)
			.map(i -> nums[i])
			.sum();


	}

}
