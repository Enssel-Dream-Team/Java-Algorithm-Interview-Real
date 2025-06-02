package minsun.hashtable;

import java.util.*;

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int answer = 0;

        for (int r=0;r<s.length();r++){
            set.add(s.charAt(r));

            answer = Math.max(answer, set.size());

            while (r - l + 1 != set.size()) {
                if (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l));
                }
                l++;
            }
        }

        return answer;
    }
}
