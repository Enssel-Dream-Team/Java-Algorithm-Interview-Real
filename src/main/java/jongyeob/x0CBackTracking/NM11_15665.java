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

public class NM11_15665 {
    private static Set<NM> set = new HashSet();
    private static Deque<NM> deque = new ArrayDeque<>();
    private static int[] trackingArray;
    private static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        inputs = new int[N];
        trackingArray = new int[M];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(inputs);
        backtracking(N, M, 0);
        StringBuilder builder = new StringBuilder();
        for (NM nm : deque) {
            for (int anInt : nm.values) {
                builder.append(anInt).append(" ");
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }

    private static void backtracking(int n, int m, int depth) {
        if (depth == m) {
            NM nm = new NM(trackingArray);
            if (set.add(nm)) {
                deque.addLast(nm);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            trackingArray[depth] = inputs[i];
            backtracking(n, m, depth + 1);
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
