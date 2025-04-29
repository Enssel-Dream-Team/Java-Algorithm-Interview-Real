package seonguk.string;

public class LeetCode_5_LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        int len = s.length();
        for(int i = len; i > 0; i--) {
            for(int j = 0; j < len - i + 1; j++) {
                String str = s.substring(j, j + i);
                if(isPalindrome(str, i))
                    return str;
            }
        }

        return "";
    }

    public static boolean isPalindrome(String str, int len) {
        for(int i = 0; i < len / 2; i++)
            if(str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        return true;
    }
}
