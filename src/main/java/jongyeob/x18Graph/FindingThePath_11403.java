package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindingThePath_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value == 1) {
                    graph[i].add(j);
                }
            }
        }
        getRouteMap(n, graph, map);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(map[i][j]).append(" ");
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }

    private static void getRouteMap(int n, ArrayList<Integer>[] graph, int[][] map) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (Integer child : graph[i]) {
                map[i][child] = 1;
                queue.add(child);
            }
            queue.addAll(graph[i]);
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                for (Integer child : graph[current]) {
                    if (map[i][child] == 0) {
                        map[i][child] = 1;
                        queue.add(child);
                    }
                }
            }
        }
    }
}
