package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindTheMarbles_2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] lowToHighGraph = new ArrayList[n + 1];
        ArrayList<Integer>[] highToLowGraph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            lowToHighGraph[i] = new ArrayList<>();
            highToLowGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int high = Integer.parseInt(tokenizer.nextToken());
            int low = Integer.parseInt(tokenizer.nextToken());
            lowToHighGraph[low].add(high);
            highToLowGraph[high].add(low);
        }
        int cantMiddleValue = 0;
        int halfNode = (n - 1) / 2;
        for (int i = 1; i < n + 1; i++) {
            int higherChildren = calculateChildrenNum(n, i, lowToHighGraph);
            int lowerChildren = calculateChildrenNum(n, i, highToLowGraph);
            if (higherChildren > halfNode || lowerChildren > halfNode) {
                cantMiddleValue++;
            }
        }
        System.out.println(cantMiddleValue);
    }

    private static int calculateChildrenNum(int n, int rootIndex, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[rootIndex] = true;
        queue.add(rootIndex);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer child : graph[current]) {
                if (!visited[child]) {
                    count++;
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
        return count;
    }
}
