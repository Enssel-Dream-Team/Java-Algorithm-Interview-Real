package jongyeob.x06Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = reader.readLine();
        }
        String result = solve(commands);
        System.out.println(result);
    }

    private static String solve(String[] commands) {
        Queue<String> que = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (String command : commands) {
            switch (command) {
                case "pop":
                    String pop = que.isEmpty() ? "-1" : que.poll();
                    builder.append(pop + "\n");
                    break;
                case "size":
                    builder.append(que.size() + "\n");
                    break;
                case "empty":
                    String empty = que.isEmpty() ? "1" : "0";
                    builder.append(empty + "\n");
                    break;
                case "front":
                    String front = que.isEmpty() ? "-1" : que.peek();
                    builder.append(front + "\n");
                    break;
                case "back":
                    String back;
                    if (que.isEmpty())
                        back = "-1";
                    else {
                        for (int i = 0; i < que.size() - 1; i++) {
                            que.add(que.poll());
                        }
                        back = que.peek();
                        que.add(que.poll());
                    }
                    builder.append(back + "\n");
                    break;
                default:
                    String value = command.split(" ")[1];
                    que.add(value);
            }
        }
        return builder.toString();
    }
}
