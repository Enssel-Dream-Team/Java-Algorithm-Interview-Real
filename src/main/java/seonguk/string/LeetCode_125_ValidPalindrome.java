package seonguk.string;

public class LeetCode_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = filter(s);
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while(leftIdx <= rightIdx) {
            if(str.charAt(leftIdx) != str.charAt(rightIdx))
                return false;
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    static String filter(String str) {
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
                sb.append(c);
        }
        return sb.toString();
    }
}
