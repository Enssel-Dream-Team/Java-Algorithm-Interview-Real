package jongyeob.x11Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Rope_2217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = scanner.nextInt();
        }
        long result = 0;
        Arrays.sort(ropes);
        for (int i = 0; i < N; i++) {
            int currentMaxWeight = ropes[i] * (N - i);
            result = Math.max(result, currentMaxWeight);
        }
        System.out.println(result);
    }
}
