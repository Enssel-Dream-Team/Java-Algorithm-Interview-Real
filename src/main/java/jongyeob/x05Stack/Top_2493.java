package jongyeob.x05Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Top_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] rawInput = bufferedReader.readLine().split(" ");
        int[] input = new int[N + 1];
        input[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            input[i] = Integer.parseInt(rawInput[i - 1]);
        }
        bufferedReader.close();

        String result = solve(input);
        System.out.println(result);
    }

    private static String solve(int[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(input[0]);
        for (int i = 1; i < input.length; i++) {
            while (stack.size() > 1 && input[i] > input[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 1) {
                stringBuilder.append("0 ");
            } else {
                stringBuilder.append(stack.peek()).append(" ");
            }

            stack.push(i);
        }
        return stringBuilder.toString();
    }

}
