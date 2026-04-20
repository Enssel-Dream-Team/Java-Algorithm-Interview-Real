package seonguk.leetcode;

import java.util.*;

public class P02078 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] colors = {1,1,1,6,1,1,1};
        System.out.println(s.maxDistance(colors));
    }

    static class Solution {
        public int maxDistance(int[] colors) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(colors[0], 0);

            int ans = 0;
            for (int i = 1; i < colors.length; i++) {
                if (!map.containsKey(colors[i])) {
                    map.put(colors[i], i);
                }
                for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                    if (e.getKey() != colors[i]) {
                        ans = Math.max(ans, Math.abs(e.getValue() - i));
                    }
                }
            }

            return ans;
        }
    }
}
