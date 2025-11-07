package jongyeob.x0CBackTracking;

import java.util.Scanner;

public class NM3_15651 {
    private static StringBuilder builder = new StringBuilder();
    private static int[] dfsArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        dfsArray = new int[M];
        backtracking(N, M, 0);
        System.out.println(builder);
    }

    private static void backtracking(int n, int m, int depth) {
        if (depth == m) {
            for (int i : dfsArray) {
                builder.append(i).append(" ");
            }
            builder.append('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {
            dfsArray[depth] = i;
            backtracking(n, m, depth + 1);
        }
    }
}