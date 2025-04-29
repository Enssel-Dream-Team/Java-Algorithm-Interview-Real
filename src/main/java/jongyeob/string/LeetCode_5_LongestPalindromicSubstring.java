package jongyeob.string;

public class LeetCode_5_LongestPalindromicSubstring {
    static String result = "";

    public static String longestPalindrome(String s) {
        if (s.length() < 3) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = getPalindromeLength(s, i, i); // 짝수
            int evenLength = getPalindromeLength(s, i, i + 1); // 홀수
            int len = Math.max(oddLength, evenLength);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int getPalindromeLength(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
