package seonguk.leetcode;

import java.util.*;

public class P01291 {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < 10; j++) {
                    sb.append(j);
                    int num = Integer.parseInt(sb.toString());
                    if (num >= low && num <= high) {
                        ans.add(num);
                    } else if (num > high) {
                        break;
                    }
                }
            }

            Collections.sort(ans);
            return ans;
        }
    }
}
