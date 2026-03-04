package jongyeob.x1ATopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MusicProgram_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] degree = new int[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        getInput(m, reader, graph, degree);

        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        int numOfPolled = 0;
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            numOfPolled++;
            builder.append(current).append('\n');
            for (Integer child : graph[current]) {
                degree[child]--;
                if (degree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if (numOfPolled == n) {
            System.out.println(builder);
        } else {
            System.out.println(0);
        }
    }

    private static void getInput(int m, BufferedReader reader, ArrayList<Integer>[] graph, int[] degree) throws
        IOException {
        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int numOfSinger = Integer.parseInt(tokenizer.nextToken());
            if (numOfSinger >= 2) {
                int pre = Integer.parseInt(tokenizer.nextToken());
                for (int j = 0; j < numOfSinger - 1; j++) {
                    int after = Integer.parseInt(tokenizer.nextToken());
                    graph[pre].add(after);
                    degree[after]++;
                    pre = after;
                }
            }
        }
    }
}
