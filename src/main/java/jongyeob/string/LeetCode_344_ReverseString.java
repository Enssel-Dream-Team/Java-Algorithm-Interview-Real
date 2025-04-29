package jongyeob.string;

import java.io.IOException;

public class LeetCode_344_ReverseString {
    public static void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
    public static void main(String[] args) throws IOException {
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
    }
}
