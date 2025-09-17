package jongyeob.x05Stack;

import java.util.Scanner;
import java.util.Stack;

public class DecoratingRoofTopGarden_6198 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
        }
        Long result = solve(input);
        System.out.println(result);
    }

    private static Long solve(int[] input) {
        Long result = 0L;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= input[i]) {
                stack.pop();
            }
            result += stack.size();
            stack.push(input[i]);
        }
        return result;
    }
}