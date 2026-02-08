package jongyeob.x19Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindingTheParentsOfTree_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int parent = Integer.parseInt(tokenizer.nextToken());
            int child = Integer.parseInt(tokenizer.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }
        int[] results = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (!visit[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer parent = queue.poll();
                    visit[parent] = true;
                    for (Integer child : graph[parent]) {
                        if (!visit[child]) {
                            results[child] = parent;
                            queue.add(child);
                        }
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            builder.append(results[i]).append('\n');
        }
        System.out.println(builder);
    }
}
