package sehyuk.stackqueue;

import java.util.Stack;

public class LeetCode_739_DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] result= new int[temperatures.length];
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0; i<temperatures.length;i++){
			while(!stack.isEmpty()){
				if(temperatures[stack.peek()]<temperatures[i]){
					int idx = stack.pop();
					result[idx]=i-idx;
					continue;
				}else{
					break;
				}
			}
			stack.push(i);
		}
		return result;
	}
}
