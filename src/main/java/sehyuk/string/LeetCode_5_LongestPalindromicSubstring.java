package sehyuk.string;

/**
 *   5. Longest Palindromic Substring
 *   Link : https://leetcode.com/problems/longest-palindromic-substring/description
 *   explanation :
 *   1. 먼저 자신 하나는 무조건 true이므로 true로 체크한다.
 *   2. 길이가 2인 팰린드롭을 찾고 dp에 true로 체크한다.
 *   3. 이중 for문을 통해 순회하면서 시작과 끝 값을 비교하고, 같으면 이전 dp에 그 사이 값이 팰린드롭인지 확인한다.
 *   4. 저장했던 가장 긴 문자열의 길이보다 길다면 문자열을 교체한다.
 *
 */
public class LeetCode_5_LongestPalindromicSubstring {
	public static void main(String[] args){
		String word="aaaa";
		longestPalindrome(word);
	}
	public static String longestPalindrome(String s) {
		String maxWord=String.valueOf(s.charAt(0));
		boolean[][] dp= new boolean[s.length()][s.length()];

		for(int i=0; i<s.length();i++){
			dp[i][i]=true;
		}

		for(int i=0; i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				dp[i][i+1]=true;
				maxWord=s.substring(i,i+2);
			}
		}

		for(int i=2; i<s.length(); i++){
			for(int j=0;j<s.length()-i;j++){
				if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]){
					dp[j][j+i]=true;
					if((i+1)>maxWord.length()){
						maxWord=s.substring(j,j+i+1);
					}
				}
			}
		}
		return maxWord;

	}
	public static String longestPalindrome2(String s) {
		int max=1;
		int x=0;
		int y=0;
		boolean[][] dp= new boolean[s.length()][s.length()];

		for(int i=0; i<s.length();i++){
			dp[i][i]=true;
		}

		for(int i=0; i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				dp[i][i+1]=true;
				max=2;
				x=i;
				y=i+1;
			}
		}

		for(int i=2; i<s.length(); i++){
			for(int j=0;j<s.length()-i;j++){
				if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]){
					dp[j][j+i]=true;
					if((i+1)>max){
						max=i+1;
						x=j;
						y=j+i;
					}
				}
			}
		}
		return s.substring(x,y+1);

	}

}
