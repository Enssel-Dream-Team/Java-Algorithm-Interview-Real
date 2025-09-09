package jongyeob.x03Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Stack_10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer> stack;

    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        String[] commands = loadCommand(input);
        br.close();

        int[] results = solve(commands);
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static void initStack() {
        stack = new LinkedList<>();
    }

    private static String[] loadCommand(int input) throws IOException {
        String[] commands = new String[input];
        for (int i = 0; i < input; i++) {
            commands[i] = br.readLine();
        }
        return commands;
    }

    private static boolean isPushCommand(String command) {
        return command.contains("push");
    }

    private static int executeCommand(String command) {
        return switch (command) {
            case "pop" -> stack.isEmpty() ? -1 : stack.removeLast();
            case "size" -> stack.size();
            case "empty" -> stack.isEmpty() ? 1 : 0;
            case "top" -> stack.isEmpty() ? -1 : stack.peekLast();
            default -> 0;
        };

    }

    public static int[] solve(String[] commands) {
        initStack();
        LinkedList<Integer> result = new LinkedList<>();
        for (String command : commands) {
            if (isPushCommand(command)) {
                int inputNum = Integer.parseInt(command.split(" ")[1]);
                stack.add(inputNum);
            } else {
                int commandResult = executeCommand(command);
                result.add(commandResult);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
