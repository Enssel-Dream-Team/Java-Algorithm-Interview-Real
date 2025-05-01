package string;

class LeetCode_5_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i=s.length() - 1;i >= 0;i--){
			for (int j=i; j < s.length();j++){
				if (i == j) {
					dp[i][j] = 1;
					continue;
				}

				if (j == i + 1 && s.charAt(i) == s.charAt(j)){
					dp[i][j] = 2;
					continue;
				}

				if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1] > 0) dp[i][j] = dp[i + 1][j - 1] + 2;
			}
		}

		String answer = "";
		int maxLength = 0;
		for (int i=0;i<s.length();i++){
			for (int j=0;j < s.length();j++){
				if (maxLength < dp[i][j]){
					answer = s.substring(j - dp[i][j] + 1, j + 1);
					maxLength = dp[i][j];
				}
			}
		}
		return answer;
	}


}