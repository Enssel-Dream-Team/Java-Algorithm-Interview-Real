package seonguk.deque;

import java.util.HashSet;

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();

		int startIdx = 0;
		int endIdx = 0;
		HashSet<Character> set = new HashSet<>();

		int ans = 0;
		while(endIdx < chars.length){
			if(!set.contains(chars[endIdx])){
				set.add(chars[endIdx]);
				ans = Math.max(ans, endIdx - startIdx + 1);
			} else {
				while(chars[startIdx] != chars[endIdx]){
					set.remove(chars[startIdx++]);
				}
				startIdx++;
			}
			endIdx++;
		}
		return ans;
	}
}
