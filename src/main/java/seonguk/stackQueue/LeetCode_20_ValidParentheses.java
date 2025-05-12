package seonguk.stackQueue;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : arr) {
            if(stack.isEmpty()) {
                if(c == ')' || c == '}' || c == ']')
                    return false;
                stack.push(c);
            }
            else if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if(check(stack.peek(), c))
                stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }

    static boolean check(char left, char right) {
        if(left == '(' && right == ')')
            return true;
        if(left == '{' && right == '}')
            return true;
        if(left == '[' && right == ']')
            return true;
        return false;
    }
}
