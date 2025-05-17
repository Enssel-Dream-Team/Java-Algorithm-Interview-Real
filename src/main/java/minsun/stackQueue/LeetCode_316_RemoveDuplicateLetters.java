package minsun.stackQueue;

import java.util.*;

class LeetCode_316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        Set<Character> set = new HashSet<>();

        for (int i=0;i<s.length();i++){
            Character cur = s.charAt(i);

            if (set.contains(cur)) continue;

            while (!stack.isEmpty() && stack.peek() > cur && map.get(stack.peek()) > i){
                set.remove(stack.pop());
            }

            stack.push(cur);
            set.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);

        return sb.toString();
    }
}