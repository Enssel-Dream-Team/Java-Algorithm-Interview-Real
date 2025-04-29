package hyeongil.string;

/**
 *
 * Given a string s,
 * return the longest palindromic substring in s.
 *
 * 문자열 s가 주어지고, 그 중 가장 긴 펠린드롬을 가지는 substring을 구하는 문제.
 */
public class LeetCode_5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        String oddCandidate = oddCandidate(s, length);
        String evenCandidate = evenCandidate(s, length);
        return oddCandidate.length() > evenCandidate.length() ? oddCandidate : evenCandidate;
    }

    private String oddCandidate(String s, int length) {
        String maxPalindrome = "";
        for (int i = 0; i < length; i++) {
            // start 위치에 있는 문자열이 팰린드롬이 아닐때 양쪽으로 확장해 나아간다.
            int start = i;
            int end = start + 1;
            if (end > length) {
                continue;
            }

            while (isPalindrome(s, start, end)) {
                start -= 1;
                end += 1;
            }

            String candidate = s.substring(start + 1, end - 1);
            if (maxPalindrome.length() < candidate.length()) {
                maxPalindrome = candidate;
            }
        }
        return maxPalindrome;
    }

    private String evenCandidate(String s, int length) {
        String maxPalindrome = "";
        for (int i = 0; i < length; i++) {
            // start 위치에 있는 문자열이 팰린드롬이 아닐때 양쪽으로 확장해 나아간다.
            int start = i;
            int end = start + 2;
            if (end > length) {
                continue;
            }

            while (isPalindrome(s, start, end)) {
                start -= 1;
                end += 1;
            }

            String candidate = s.substring(start + 1, end - 1);
            if (maxPalindrome.length() < candidate.length()) {
                maxPalindrome = candidate;
            }
        }
        return maxPalindrome;
    }

    public boolean isPalindrome(String s, int start, int end) {
        // 문자열의 인덱스 범위를 벗어날 경우, 팰린드롬이 될 수 없다.
        if (start < 0 || end > s.length()) {
            return false;
        }

        String candidatePalindrome = s.substring(start, end);
        int length = candidatePalindrome.length();
        for (int i = 0; i < length / 2; i++) {
            if (candidatePalindrome.charAt(i) != candidatePalindrome.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_5_LongestPalindromicSubstring problem6 = new LeetCode_5_LongestPalindromicSubstring();
        System.out.println(problem6.longestPalindrome("cbbd"));
    }
}
