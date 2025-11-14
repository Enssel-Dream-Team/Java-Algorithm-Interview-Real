package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lotte_6603 {
    private static int[] inputs;
    private static boolean[] visited;
    private static int[] trackingArray = new int[6];
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] seperatedInput = reader.readLine().split(" ");
            if (seperatedInput[0].equals("0")) {
                break;
            }
            inputs = new int[Integer.parseInt(seperatedInput[0])];
            visited = new boolean[seperatedInput.length];
            for (int i = 1; i < seperatedInput.length; i++) {
                inputs[i - 1] = Integer.parseInt(seperatedInput[i]);
            }
            Arrays.sort(inputs);
            backtracking(0, 0);
            builder.append('\n');
        }
        System.out.println(builder);
    }

    private static void backtracking(int start, int depth) {
        if (depth == 6) {
            for (int val : trackingArray) {
                builder.append(val).append(" ");
            }
            builder.append('\n');
            return;
        }
        for (int i = start; i < inputs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                trackingArray[depth] = inputs[i];
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
