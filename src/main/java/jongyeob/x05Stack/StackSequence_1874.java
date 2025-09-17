package jongyeob.x05Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackSequence_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] targets = new int[N];
        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(br.readLine().trim());
        }
        System.out.print(solve(targets));
    }

    private static String solve(int[] targets) {
        StringBuilder sb = new StringBuilder();

        int n = targets.length;
        int[] stack = new int[n];
        int top = -1;

        int next = 1;
        for (int target : targets) {
            while (next <= target) {
                stack[++top] = next++;
                sb.append("+\n");
            }

            if (top < 0 || stack[top] != target) {
                return "NO";
            }

            top--;
            sb.append("-\n");
        }
        return sb.toString();
    }
}
