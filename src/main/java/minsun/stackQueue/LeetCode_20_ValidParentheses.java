package minsun.stackQueue;

import java.util.*;

class LeetCode_20_ValidParentheses {
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){
            if (!stack.isEmpty() && map.getOrDefault(stack.peek(), ' ') == s.charAt(i)){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}