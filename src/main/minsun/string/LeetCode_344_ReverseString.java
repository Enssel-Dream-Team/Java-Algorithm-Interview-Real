package string;

public class LeetCode_344_ReverseString {
    public void reverseString(char[] s) {
        for (int i=0;i<s.length / 2;i++){
            char cur = s[i];
            char counter = s[s.length - i - 1];

            char temp = cur;
            s[i] = counter;
            s[s.length - i - 1] = temp;
        }
    }
}