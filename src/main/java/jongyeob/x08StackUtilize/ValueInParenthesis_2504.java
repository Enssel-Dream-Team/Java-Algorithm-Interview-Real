package jongyeob.x08StackUtilize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValueInParenthesis_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();
        int result = solve(input);
        System.out.println(result);
    }

    private static int solve(String input) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int current = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[' || c == '(') {
                current *= (c == '[' ? 3 : 2);
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return 0;
                stack.pop();
                if (i - 1 > -1 && input.charAt(i - 1) == '(')
                    result += current;
                current /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }
                stack.pop();
                if (i - 1 > -1 && input.charAt(i - 1) == '[')
                    result += current;
                current /= 3;
            }
        }
        if (!stack.isEmpty())
            return 0;
        return result;
    }
}
