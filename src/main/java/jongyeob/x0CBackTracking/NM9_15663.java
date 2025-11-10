package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class NM9_15663 {
    private static int[] dfsArray;
    private static int[] inputs;
    private static boolean[] visited;
    private static Deque<NM> deque = new ArrayDeque<>();
    private static Set<NM> visitedSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
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
        backtracking(N, M, 0);
        preparePrintData(builder);
        System.out.println(builder);
    }

    private static void preparePrintData(StringBuilder builder) {
        for (NM nm : deque) {
            for (int n : nm.values) {
                builder.append(n).append(" ");
            }
            builder.append('\n');
        }
    }

    private static void backtracking(int n, int m, int depth) {
        if (depth == m) {
            NM newValues = new NM(dfsArray);
            if (visitedSet.add(newValues)) {
                deque.addLast(newValues);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsArray[depth] = inputs[i];
                visited[i] = true;
                backtracking(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static class NM {
        int[] values;

        public NM(int[] values) {
            this.values = Arrays.copyOf(values, values.length);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            NM nm = (NM)o;
            return Objects.deepEquals(values, nm.values);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(values);
        }

    }

}
