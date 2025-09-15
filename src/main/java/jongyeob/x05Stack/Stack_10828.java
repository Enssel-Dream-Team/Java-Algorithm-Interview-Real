package jongyeob.x05Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = reader.readLine();
        }
        reader.close();
        String result = solve(commands);
        System.out.println(result);
    }

    private static String solve(String[] commands) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String command : commands) {
            if (command.contains("push")) {
                String value = command.split(" ")[1];
                stack.push(value);
            } else if (command.contains("pop")) {
                String popValue = stack.isEmpty() ? "-1" : stack.pop();
                stringBuilder.append(popValue + "\n");
            } else if (command.contains("size")) {
                stringBuilder.append(stack.size() + "\n");
            } else if (command.contains("empty")) {
                String value = stack.isEmpty() ? "1" : "0";
                stringBuilder.append(value + "\n");
            } else {
                String topValue = stack.isEmpty() ? "-1" : stack.peek();
                stringBuilder.append(topValue + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
