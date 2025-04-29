package yjham.string;

public class LeetCode_125_ValidPalindrome {

	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		if (s.isEmpty()) return true;
		s = s.toLowerCase();
		int len = s.length() - 1;

		for (int i = 0; i <= len/2; i++) {
			if(s.charAt(i) != s.charAt(len - i)) return false;
		}

		return true;
	}
}
