package seonguk.leetcode;

import java.util.*;

public class P01189 {
    class Solution {
        public int maxNumberOfBalloons(String text) {
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = new char[26];
            init(map);

            for(char c : text.toCharArray()) {
                arr[c - 'a']++;
            }

            int ans = 10000;
            for (char c : map.keySet()) {
                int val = map.get(c);
                ans = Math.min(ans, arr[c - 'a'] / val);
            }

            return ans;
        }

        static void init(Map<Character, Integer> map) {
            map.put('b', 1);
            map.put('a', 1);
            map.put('l', 2);
            map.put('o', 2);
            map.put('n', 1);
        }
    }
}
