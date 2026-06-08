package seonguk.leetcode;

import java.util.*;

public class P02161 {

    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int n = nums.length;
            int[] result = new int[n];
            Arrays.fill(result, pivot);

            int leftIdx = 0;
            List<Integer> right = new ArrayList<>();

            for (int num : nums) {
                if (num < pivot) {
                    result[leftIdx++] = num;
                } else if (num > pivot) {
                    right.add(num);
                }
            }

            int s = right.size();
            for (int i = 0; i < s; i++) {
                result[n - s + i] = right.get(i);
            }

            return result;
        }
    }
}
