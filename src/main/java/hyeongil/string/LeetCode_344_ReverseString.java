package hyeongil.string;
/**
 Write a function that reverses a string.
 The input string is given as an array of characters s.

 You must do this by modifying the input array in-place with O(1) extra memory.

 추가적인 메모리를 사용하지 말 것
 */
public class LeetCode_344_ReverseString {
    public static void reverseString(char[] s) {

        int reverseCount = s.length / 2;
        for (int count = 0; count < reverseCount; count++) {
            int front = count;
            int rear = s.length - 1 - count;
            swap(s, front, rear);
        }

        System.out.println(s);
    }

    private static void swap(char[] s, int front, int rear) {
        char temp = s[front];
        s[front] = s[rear];
        s[rear] = temp;
    }

    public static void main(String[] args) {
        reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
    }
}
