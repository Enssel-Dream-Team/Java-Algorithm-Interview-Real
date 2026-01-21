package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PresidentialElection_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        ArrayList<Integer>[] score = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            score[i] = new ArrayList<>();
        }
        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            if (x == -1 && y == -1) {
                break;
            }
            graph[x].add(y);
            graph[y].add(x);
        }
        calculateMaxDistance(n, graph, score);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (score[i].size() > 0) {
                builder.append(i).append(' ').append(score[i].size()).append('\n');
                for (Integer integer : score[i]) {
                    builder.append(integer).append(' ');
                }
                break;
            }
        }
        System.out.println(builder);
    }

    private static void calculateMaxDistance(int n, ArrayList<Integer>[] graph, ArrayList<Integer>[] score) {
        for (int i = 1; i < n + 1; i++) {
            calculateDistance(n, i, graph, score);
        }
    }

    private static void calculateDistance(int n, int rootIndex, ArrayList<Integer>[] graph,
        ArrayList<Integer>[] score) {
        Queue<Node> queue = new ArrayDeque<>();
        int maxDistance = 0;
        boolean[] visited = new boolean[n + 1];
        queue.add(new Node(rootIndex, 0));
        visited[rootIndex] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            ArrayList<Integer> children = graph[current.index];
            for (Integer child : children) {
                if (!visited[child]) {
                    visited[child] = true;
                    int nextDistance = current.distance + 1;
                    queue.add(new Node(child, nextDistance));
                    maxDistance = Math.max(maxDistance, nextDistance);
                }
            }
        }
        score[maxDistance].add(rootIndex);
    }

    private static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
