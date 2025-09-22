package jongyeob.x07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = reader.readLine();
        }
        reader.close();
        String solve = solve(commands);
        System.out.println(solve);
    }

    private static String solve(String[] commands) {
        StringBuilder builder = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        for (String command : commands) {
            switch (command) {
                case "pop_front":
                    String popFront = deque.isEmpty() ? "-1" : deque.pollFirst();
                    builder.append(popFront + "\n");
                    break;
                case "pop_back":
                    String popBack = deque.isEmpty() ? "-1" : deque.pollLast();
                    builder.append(popBack + "\n");
                    break;
                case "size":
                    builder.append(deque.size() + "\n");
                    break;
                case "empty":
                    builder.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    String peekFront = deque.isEmpty() ? "-1" : deque.peekFirst();
                    builder.append(peekFront + "\n");
                    break;
                case "back":
                    String peekBack = deque.isEmpty() ? "-1" : deque.peekLast();
                    builder.append(peekBack + "\n");
                    break;
                default:
                    String value = command.split(" ")[1];
                    if (command.contains("front"))
                        deque.addFirst(value);
                    else
                        deque.addLast(value);
            }
        }
        return builder.toString();
    }
}
