package minsun.array;

import java.util.*;

class LeetCode_238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int[] accMul = new int[n];

        accMul[n - 1] = nums[n - 1];
        for (int i=1;i<n;i++){
            answer[i] = answer[i - 1] * nums[i - 1];
            accMul[n - i - 1] = accMul[n - i] * nums[n - i - 1];
        }

        for (int i=0;i<n - 1;i++){
            answer[i] *= accMul[i + 1];
        }

        return answer;
    }
}