package hyeongil.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
    중복된 문자를 제거하고, 사전 편찬순에서 가장 작은 문자열을 구하는 문제
 */
public class LeetCode_316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 등장한 문자의 개수
        Map<Character, Integer> counter = new HashMap<>();
        // 이미 처리한 문자인지 확인
        Map<Character, Boolean> seen = new HashMap();

        Deque<Character> stack = new ArrayDeque<>();

        // 문자 등장 개수를 카운트한다.
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        //
        for (char c : s.toCharArray()) {
            // 현재 처리하는 문자에 대해, -1
           counter.put(c, counter.getOrDefault(c, 0) - 1);

           // 이미 처리한 경우, 건너 뛴다.
            if (seen.get(c) != null && seen.get(c) == true) {
                continue;
            }

            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙어야 할 문자라면 스택에서 제거한다.
            // 현재 문자보다 뒤에 있어도 될 문자라면, 나중에 처리하도록 한다.
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }

            // 현재 문자 push
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}
