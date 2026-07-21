package seonguk.leetcode;

import java.util.*;

public class P03499 {
    class Solution {
        public int maxActiveSectionsAfterTrade(String s) {
            String str = "1" + s + "1";
            List<Integer> list = new ArrayList<>();

            char before = '1';
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (before == c) {
                    cnt++;
                    continue;
                }

                list.add(cnt);
                cnt = 1;
                before = c;
            }

            list.add(cnt);

            int one = 0;
            for (int i = 0; i < list.size(); i += 2) {
                one += list.get(i);
            }

            one -= 2;

            int zero = 0;
            for (int i = 1; i < list.size() - 2; i += 2) {
                zero = Math.max(zero, list.get(i) + list.get(i + 2));
            }

            return one + zero;
        }
    }
}
