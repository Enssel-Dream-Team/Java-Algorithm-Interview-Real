package jongyeob.x0CBackTracking;

import java.util.Scanner;

public class NM4_15652 {
    private static StringBuilder builder = new StringBuilder();
    private static int[] dfsArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        dfsArray = new int[M];
        backtracking(1, N, M, 0);
        System.out.println(builder);
    }

    private static void backtracking(int start, int n, int m, int depth) {
        if (depth == m) {
            for (int i : dfsArray) {
                builder.append(i).append(" ");
            }
            builder.append('\n');
            return;
        }
        for (int i = start; i <= n; i++) {
            dfsArray[depth] = i;
            backtracking(i, n, m, depth + 1);
        }
    }
}
