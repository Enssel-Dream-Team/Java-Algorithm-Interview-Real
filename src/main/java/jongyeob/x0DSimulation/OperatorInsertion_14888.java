package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperatorInsertion_14888 {
    private static int N;
    private static int[] inputs, operation;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        inputs = new int[N];
        operation = new int[4];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            inputs[i] = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++)
            operation[i] = Integer.parseInt(tokenizer.nextToken());

        simulate(inputs[0], 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void simulate(int current, int depth) {
        if (depth == N - 1) {
            min = Math.min(current, min);
            max = Math.max(current, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) {
                    simulate(current + inputs[depth + 1], depth + 1);
                } else if (i == 1) {
                    simulate(current - inputs[depth + 1], depth + 1);
                } else if (i == 2) {
                    simulate(current * inputs[depth + 1], depth + 1);
                } else {
                    simulate(current / inputs[depth + 1], depth + 1);
                }
                operation[i]++;
            }
        }
    }
}
