package jongyeob.x08StackUtilize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] results = new String[N];
        for (int i = 0; i < N; i++) {
            results[i] = solve(reader.readLine());
        }
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return "NO";
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty())
            return "YES";
        return "NO";
    }
}
