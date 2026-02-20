package jongyeob.x1ATopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            builder.append(current).append(" ");
            for (Integer child : graph[current]) {
                if (inDegree[child] - 1 == 0) {
                    queue.add(child);
                }
                inDegree[child]--;
            }
        }

        System.out.println(builder);
    }
}
