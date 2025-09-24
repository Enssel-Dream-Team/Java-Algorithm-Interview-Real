package jongyeob.x08StackUtilize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronBar_10799 {
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
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (input.charAt(i - 1) == '(')
                    result += stack.size();
                else
                    result++;
            }
        }
        return result;
    }
}
