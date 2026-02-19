package jongyeob.x1ATopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Work_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] workTime = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            workTime[i] = Integer.parseInt(tokenizer.nextToken());
            int numOfParents = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < numOfParents; j++) {
                graph[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            int sum = workTime[i];
            ArrayList<Integer> children = graph[i];
            int maxOfParents = 0;
            for (Integer child : children) {
                maxOfParents = Math.max(maxOfParents, dp[child]);
            }
            dp[i] = sum + maxOfParents;
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
