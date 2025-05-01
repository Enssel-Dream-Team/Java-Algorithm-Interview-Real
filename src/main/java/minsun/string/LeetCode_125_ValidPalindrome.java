package string;

import java.util.*;

public class LeetCode_125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		StringTokenizer st = new StringTokenizer(s);
		String word = "";
		while (st.hasMoreTokens()){
			String cur = st.nextToken();
			for (char ch: cur.toCharArray()){
				if (isAlphaNumeric(ch)) {
					word += ch;
				}
			}
		}

		word = word.toLowerCase();

		if (isValidPalindrome(word)) return true;
		return false;
	}

	private static boolean isAlphaNumeric(char ch){
		if (ch - '0' >= 0 && ch - '0' <= 9 || ch >= 97 && ch < 123 || ch >= 65 && ch < 91) return true;
		return false;
	}

	private static boolean isValidPalindrome(String word){
		for (int i=0;i<word.length();i++){
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) return false;
		}
		return true;
	}
}