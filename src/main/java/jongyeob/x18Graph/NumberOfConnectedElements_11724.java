package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfConnectedElements_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        int result = connected(n, graph);
        System.out.println(result);
    }

    private static int connected(int n, ArrayList<Integer>[] graph) {
        boolean[] isVisted = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!isVisted[i]) {
                scanConnected(graph, i, isVisted);
                count++;
            }
        }
        return count;
    }

    private static void scanConnected(ArrayList<Integer>[] graph, int i, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer child : graph[i]) {
            if (!isVisited[child]) {
                queue.add(child);
                isVisited[child] = true;
            }
        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer child : graph[current]) {
                if (!isVisited[child]) {
                    queue.add(child);
                    isVisited[child] = true;
                }
            }
        }
    }
}
