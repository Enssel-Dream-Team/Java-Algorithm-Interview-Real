package jongyeob.x04LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Editor_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        int numOfCommand = Integer.parseInt(br.readLine());
        String[] commands = new String[numOfCommand];
        for (int i = 0; i < numOfCommand; i++) {
            commands[i] = br.readLine();
        }
        String result = solve(inputString, commands);
        System.out.println(result);
    }

    static String solve(String inputString, String[] commands) {
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < inputString.length(); i++) {
            left.push(inputString.charAt(i));
        }

        for (String cmd : commands) {
            char op = cmd.charAt(0);
            switch (op) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    left.push(cmd.charAt(2));
                    break;
                default:
            }
        }

        StringBuilder sb = new StringBuilder(left.size() + right.size());
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        return sb.toString();
    }
}
