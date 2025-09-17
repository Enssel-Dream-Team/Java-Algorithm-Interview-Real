package jongyeob.x05Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RightGreaterNumber_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String result = solve(input);
        System.out.println(result);
    }

    private static String solve(int[] input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[input.length];
        result[input.length - 1] = -1;
        stack.push(input[input.length - 1]);
        for (int i = input.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= input[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            stack.push(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i < result.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
