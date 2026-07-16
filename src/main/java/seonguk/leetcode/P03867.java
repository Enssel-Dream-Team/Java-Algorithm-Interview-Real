package seonguk.leetcode;

import java.util.*;

public class P03867 {
    class Solution {
        public long gcdSum(int[] nums) {
            int n = nums.length;
            int[] prefixGcd = new int[n];

            int max = 0;
            for (int i = 0; i < n; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }

                prefixGcd[i] = gcd(max, nums[i]);
            }

            Arrays.sort(prefixGcd);
            long ans = 0;
            for (int i = 0; i < n / 2; i++) {
                ans += gcd(prefixGcd[n - 1 - i], prefixGcd[i]);
            }

            return ans;
        }

        private int gcd(int num1, int num2) {
            if (num1 % num2 == 0) {
                return num2;
            }
            return gcd(num2, num1 % num2);
        }
    }
}
