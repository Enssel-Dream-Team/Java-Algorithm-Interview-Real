package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeddingCeremony_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (distance[current] == 2) {
                continue;
            }
            for (Integer i : graph[current]) {
                if (distance[i] == 0 && i != 1) {
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                }
            }
        }

        int count = 0;
        for (int d : distance) {
            if (d == 1 || d == 2)
                count++;
        }
        System.out.println(count);

    }

}
