package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BipartiteGraph_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());

        for (int tc = 0; tc < k; tc++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex = Integer.parseInt(tokenizer.nextToken());
            int edge = Integer.parseInt(tokenizer.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[vertex + 1];
            for (int i = 1; i < vertex + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            initEdge(edge, reader, graph);
            String result = isBipartiteGraph(vertex, graph);
            System.out.println(result);
        }

    }

    private static String isBipartiteGraph(int vertex, ArrayList<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 0 = 미탐색, 1 = R, 2 = B
        int[] nodeColors = new int[vertex + 1];
        for (int start = 1; start < vertex + 1; start++) {
            if (nodeColors[start] != 0) {
                continue;
            }
            queue.add(start);
            nodeColors[start] = 1;
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                int currentColor = nodeColors[current];
                int nextColor = (currentColor == 1) ? 2 : 1;
                for (int child : graph[current]) {
                    if (nodeColors[child] == 0) {
                        queue.add(child);
                        nodeColors[child] = nextColor;
                    } else {
                        if (nodeColors[child] == currentColor) {
                            return "NO";
                        }
                    }
                }
            }
        }
        return "YES";
    }

    private static void initEdge(int edge, BufferedReader reader, ArrayList<Integer>[] graph) throws IOException {
        StringTokenizer tokenizer;
        for (int i = 0; i < edge; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
    }
}
