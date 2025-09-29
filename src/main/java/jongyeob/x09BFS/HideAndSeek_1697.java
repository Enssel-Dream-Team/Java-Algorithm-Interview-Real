package jongyeob.x09BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek_1697 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int result = solve(n, k);
        System.out.println(result);
    }

    private static int solve(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[k * 2 + 1];
        int[] visitCount = new int[k * 2 + 1];
        queue.add(n);
        if (n == k)
            return 0;
        else if (n > k)
            return n - k;

        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            if (front == k) {
                return visitCount[front];
            }
            visited[front] = true;
            int[] next = {front - 1, front + 1, 2 * front};
            for (int nx : next) {
                if (nx >= 0 && nx < 2 * k + 1 && !visited[nx]) {
                    visited[nx] = true;
                    visitCount[nx] = visitCount[front] + 1;
                    queue.add(nx);
                }
            }
        }
        return -1; //존재할 수 없음
    }

}
