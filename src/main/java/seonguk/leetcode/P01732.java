package seonguk.leetcode;

public class P01732 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int result = 0;
            int a = 0;

            for (int num : gain) {
                a += num;
                result = Math.max(result, a);
            }
            return result;
        }
    }
}
