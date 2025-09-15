package jongyeob.x04LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KeyLogger_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] encryptedStrings = new String[N];
        for (int i = 0; i < N; i++) {
            encryptedStrings[i] = reader.readLine();
        }
        String result = solve(encryptedStrings);
        System.out.println(result);
    }

    private static String solve(String[] encryptedStrings) {
        StringBuilder builder = new StringBuilder();
        for (String encryptedString : encryptedStrings) {
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            for (int i = 0; i < encryptedString.length(); i++) {
                char c = encryptedString.charAt(i);
                if (c == '<') {
                    if (!left.isEmpty())
                        right.push(left.pop());
                } else if (c == '>') {
                    if (!right.isEmpty())
                        left.push(right.pop());
                } else if (c == '-') {
                    if (!left.isEmpty())
                        left.pop();
                } else {
                    left.push(c);
                }
            }
            while (!left.isEmpty())
                right.push(left.pop());
            while (!right.isEmpty())
                builder.append(right.pop());
            builder.append("\n");
        }
        return builder.toString();
    }

}
