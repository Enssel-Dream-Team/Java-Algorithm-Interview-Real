package jongyeob.x09BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek4_13913 {

    private static final int MAX = 100001;
    private static final int[] distance = new int[MAX];
    private static final int[] parents = new int[MAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int target = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        if (start >= target) {
            builder.append(start - target).append("\n");
            for (int i = start; i >= target; i--)
                builder.append(i).append(" ");
            System.out.println(builder);
        } else {
            int result = solve(start, target);
            int[] visitNodes = getVisitInfo(start, target);
            builder.append(result).append("\n");
            for (int visitNode : visitNodes) {
                builder.append(visitNode).append(" ");
            }
            System.out.println(builder);
        }
    }

    private static int[] getVisitInfo(int start, int target) {
        ArrayList<Integer> rev = new ArrayList<>();
        for (int cur = target; ; cur = parents[cur]) {
            rev.add(cur);
            if (cur == start)
                break;
        }
        int n = rev.size();
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = rev.get(n - 1 - i);
        }
        return path;
    }

    private static int solve(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distance, MAX);
        Arrays.fill(parents, -1);
        queue.add(start);
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target)
                break;
            int[] next = {current - 1, current + 1, current * 2};
            for (int i = 0; i < 3; i++) {
                int nx = next[i];
                if (nx >= 0 && nx < MAX && distance[nx] == MAX) {
                    distance[nx] = distance[current] + 1;
                    parents[nx] = current;
                    queue.add(nx);
                }
            }
        }
        return distance[target];
    }
}
