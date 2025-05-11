package hyeongil.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s) {
        // 닫는 괄호가 나오면, 최근에 등장한 여는 괄호가 있는지 확인하고, 없다면 false를 반환한다.
        // 최근에 등장한 괄호를 탐색하기 위해서, FILO 자료구조가 필요
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 여는 괄호가 등장하면 Stack에 저장한다.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            // c == 닫는 괄호라면,
            // 맨위에 있는 괄호를 확인하고 종류에 맞는 여는 괄호인지 확인한다.

            // 닫는 괄호가 등장했는데, stack에 괄호가 존재하지 않으면 false
            if (stack.isEmpty()) {
                return false;
            }

            char popped = stack.pop();
            if (popped != '(' && c == ')') {
                return false;
            }

            if (popped != '[' && c == ']') {
                return false;
            }

            if (popped != '{' && c == '}') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
