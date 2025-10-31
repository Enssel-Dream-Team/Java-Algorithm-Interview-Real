package jongyeob.x11Greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Stock_11501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] inputs = new int[N];
            for (int i = 0; i < N; i++) {
                inputs[i] = scanner.nextInt();
            }
            long result = 0;
            int max = inputs[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (inputs[i] > max) {
                    max = inputs[i];
                } else {
                    result += (max - inputs[i]);
                }
            }
            System.out.println(result);
        }
    }
}
