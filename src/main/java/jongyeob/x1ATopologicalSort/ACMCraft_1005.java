package jongyeob.x1ATopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCase = Integer.parseInt(tokenizer.nextToken());
        for (int tc = 0; tc < testCase; tc++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(reader.readLine());
            int[] buildTime = new int[n];
            for (int i = 0; i < n; i++) {
                buildTime[i] = Integer.parseInt(tokenizer.nextToken());
            }

            ArrayList<Integer>[] graph = initGraph(n);
            int[] depth = new int[n];
            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int parent = Integer.parseInt(tokenizer.nextToken()) - 1;
                int child = Integer.parseInt(tokenizer.nextToken()) - 1;
                graph[parent].add(child);
                depth[child]++;
            }
            int[] totalTime = new int[n];
            Queue<Integer> queue = initQueue(n, depth, totalTime, buildTime);
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                int time = totalTime[current];
                for (Integer child : graph[current]) {
                    totalTime[child] = Math.max(totalTime[child], time + buildTime[child]);
                    if (depth[child] == 1) {
                        queue.add(child);
                    }
                    depth[child]--;
                }
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int node = Integer.parseInt(tokenizer.nextToken());
            System.out.println(totalTime[node - 1]);
        }
    }

    private static Queue<Integer> initQueue(int n, int[] depth, int[] totalTime, int[] buildTime) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (depth[i] == 0) {
                queue.add(i);
                totalTime[i] = buildTime[i];
            }
        }
        return queue;
    }

    private static ArrayList<Integer>[] initGraph(int n) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }
}
