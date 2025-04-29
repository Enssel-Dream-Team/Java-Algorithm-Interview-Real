package seonguk.string;

public class LeetCode_344_ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len / 2; i++) {
            char c = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = c;
        }
    }
}
