package jongyeob.x09BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek3_13549 {

    public static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int target = scanner.nextInt();
        if (start >= target)
            System.out.println(start - target);
        else {
            int result = solve(start, target);
            System.out.println(result);

        }
    }

    private static int solve(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[MAX];
        Arrays.fill(distance, MAX);
        queue.add(start);
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = {current - 1, current + 1, current * 2};
            for (int i = 0; i < 3; i++) {
                int nx = next[i];
                if (nx >= 0 && nx < MAX) {
                    if (i == 2 && distance[nx] > distance[current])
                        distance[nx] = distance[current];
                    else if (distance[nx] > distance[current] + 1)
                        distance[nx] = distance[current] + 1;
                    else
                        continue;
                    queue.add(nx);
                }
            }
        }
        return distance[target];
    }
}
