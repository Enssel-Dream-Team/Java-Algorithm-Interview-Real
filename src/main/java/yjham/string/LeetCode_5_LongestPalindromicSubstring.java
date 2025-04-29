package yjham.string;

public class LeetCode_5_LongestPalindromicSubstring {

	int len, st, ed, left, max = 1;
	char[] chs;

	public String longestPalindrome(String s) {
		len = s.length();
		chs = s.toCharArray();

		if (len == 1) return s;

		for (int i = 0; i < len; i++) {
			st = i;
			ed = i + 1;
			findMaxPalindrome();

			st = i;
			ed = i + 2;
			findMaxPalindrome();
		}

		return s.substring(left, left + max);
	}

	void findMaxPalindrome() {
		while(isValid() && isPalindrome()) {
			int ml = ed - st + 1;

			if (ml > max) {
				left = st;
				max = ml;
			}

			st--;
			ed++;
		}
	}

	boolean isValid() {
		return st >= 0 && ed < len;
	}

	boolean isPalindrome() {
		return chs[st] == chs[ed];
	}
}