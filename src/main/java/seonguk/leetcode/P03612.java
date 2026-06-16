package seonguk.leetcode;

public class P03612 {
    class Solution {
        public String processStr(String s) {
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                if (c == '#') {
                    StringBuilder temp = new StringBuilder();
                    temp.append(sb).append(sb);
                    sb = temp;
                } else if (c == '*') {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else if (c == '%') {
                    sb.reverse();
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
