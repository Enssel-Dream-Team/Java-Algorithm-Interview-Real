package seonguk.leetcode;

public class P03754 {
    class Solution {
        public long sumAndMultiply(int n) {
            char[] arr = String.valueOf(n).toCharArray();
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for(char c : arr) {
                if (c == '0') {
                    continue;
                }

                sb.append(c);
                sum += c - '0';
            }

            if (sb.length() == 0) {
                return 0;
            }
            return (long)sum * Integer.parseInt(sb.toString());
        }
    }
}
