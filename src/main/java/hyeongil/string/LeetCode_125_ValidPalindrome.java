package hyeongil.string;

public class LeetCode_125_ValidPalindrome {
	public static boolean isPalindrome(String s) {
		String lowerCase = s.toLowerCase();
		String removingNonAlphaNumeric = lowerCase.replaceAll("[^a-zA-Z0-9]", "");
		int length = removingNonAlphaNumeric.length();
		for (int i = 0; i < length / 2; i++) {
			if (removingNonAlphaNumeric.charAt(i) != removingNonAlphaNumeric.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
