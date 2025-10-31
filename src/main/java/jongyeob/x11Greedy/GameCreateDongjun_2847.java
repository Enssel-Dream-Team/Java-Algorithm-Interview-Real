package jongyeob.x11Greedy;

import java.util.Scanner;

public class GameCreateDongjun_2847 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            inputs[i] = input;
        }
        int result = 0;
        for (int i = n - 2; i >= 0; i--) {
            int gap = inputs[i + 1] - inputs[i];
            if (gap <= 0) {
                int discountValue = Math.abs(gap) + 1;
                inputs[i] -= discountValue;
                result += discountValue;
            }
        }
        System.out.println(result);
    }
}
