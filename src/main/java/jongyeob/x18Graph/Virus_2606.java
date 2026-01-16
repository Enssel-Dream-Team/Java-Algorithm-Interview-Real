package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        int num = Integer.parseInt(tokenizer.nextToken());
        for (int i = 1; i <= num; i++) {
            map.put(i, new LinkedList<>());
        }
        tokenizer = new StringTokenizer(reader.readLine());
        int vertexSize = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < vertexSize; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int node = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            map.get(node).add(value);
            map.get(value).add(node);
        }

        if (map.get(1).isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(spreadVirus(map, num));
        }

    }

    private static int spreadVirus(Map<Integer, List<Integer>> map, int num) {
        boolean[] spread = new boolean[num + 1];
        spread[1] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            spread[current] = true;
            for (Integer i : map.get(current)) {
                if (!spread[i]) {
                    queue.add(i);
                }
            }
        }
        int count = 0;
        for (boolean b : spread) {
            if (b) {
                count++;
            }
        }
        return count - 1;
    }
}
