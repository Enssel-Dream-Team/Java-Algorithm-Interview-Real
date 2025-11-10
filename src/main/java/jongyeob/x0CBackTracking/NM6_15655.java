package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM6_15655 {
    private static StringBuilder builder = new StringBuilder();
    private static int[] dfsArray;
    private static int[] inputs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        dfsArray = new int[M];
        inputs = new int[N];
        visited = new boolean[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(inputs);
        backtracking(0, N, M, 0);
        System.out.println(builder);
    }

    private static void backtracking(int start, int n, int m, int depth) {
        if (depth == m) {
            for (int i : dfsArray) {
                builder.append(i).append(" ");
            }
            builder.append('\n');
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                dfsArray[depth] = inputs[i];
                visited[i] = true;
                backtracking(i, n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
