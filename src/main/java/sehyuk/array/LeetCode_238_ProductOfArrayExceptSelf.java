package sehyuk.array;

import java.util.Arrays;

/**
 *  238. Product of Array Except Self
 *  Link : https://leetcode.com/problems/product-of-array-except-self/
 *  explanation :
 *  1. 먼저 배열을 생성하고 1로 채운다.
 *  2. 왼쪽부터 값의 곱을 누적하면서 생성한 배열의 다음 인덱스에 값을 곱한다.
 *  3. 오른쪽부터 값의 곱을 누적하면서 생성한 배열의 다음 인덱스에 값을 곱한다.
 *
 **/

public class LeetCode_238_ProductOfArrayExceptSelf {
	  public static void main(String[] args){
		int[] arr={1,2,3,4};
		productExceptSelf(arr);
	  }
	  public static int[] productExceptSelf(int[] nums) {
	        int[] resultList=new int[nums.length];
	        Arrays.fill(resultList,1);
	        int result = 1;
	        for(int i=0; i<nums.length-1;i++){
	            result*=nums[i];
	            resultList[i+1]*=result;
	        }
	        result = 1;
	        for(int i=nums.length-1; i>0;i--){
	            result*=nums[i];
	            resultList[i-1]*=result;
	        }
	        return resultList;
	 }
	
}
