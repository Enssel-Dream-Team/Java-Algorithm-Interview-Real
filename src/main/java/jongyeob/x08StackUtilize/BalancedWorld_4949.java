package jongyeob.x08StackUtilize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if (input.equals("."))
                break;
            builder.append(solve(input)).append("\n");
        }
        System.out.println(builder);
    }

    private static String solve(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[')
                stack.push(c);
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return "no";
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return "no";
            }

        }
        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}
