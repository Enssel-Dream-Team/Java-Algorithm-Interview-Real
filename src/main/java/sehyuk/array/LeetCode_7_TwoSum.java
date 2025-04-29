package sehyuk.array;

/**
 *  1. Two Sum
 *  Link : https://leetcode.com/problems/two-sum/description/
 *  explanation : 투 포인터 활용
 *  1. 실제 값과 실제 인덱스 값이 담긴 Node를 만든다.
 *  2. List에 담아 Collections를 이용해 정렬한다.
 *  3. 투 포인터를 활용해 target에 맞아떨어지는 상황을 찾는다.
 */
import java.util.*;

public class LeetCode_7_TwoSum{
	public static void main(String[] args){
		int[] arr={-1,-2,-3,-4,-5};
		twoSum(arr,-8);
	}

	static class Node implements Comparable<Node>{
		int num;
		int idx;
		public Node(int num, int idx){
			this.num=num;
			this.idx=idx;
		}

		@Override
		public int compareTo(Node n){
			return this.num-n.num;
		}
	}
	public static int[] twoSum(int[] nums, int target) {
		List<Node> list=new ArrayList<>();
		for(int i=0; i<nums.length;i++){
			list.add(new Node(nums[i],i));
		}

		Collections.sort(list);

		int start=0;
		int end=nums.length-1;
		int num;
		while(start<end){
			num=list.get(start).num+list.get(end).num;
			if(num==target){
				break;
			}else if(num<target){
				start++;
			}else{
				end--;
			}
		}
		return new int[]{list.get(start).idx,list.get(end).idx};
	}
}
