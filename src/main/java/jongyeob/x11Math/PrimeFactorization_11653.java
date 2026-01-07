package jongyeob.x11Math;

import java.util.Scanner;

public class PrimeFactorization_11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int d = 2; (long)d * d <= n; d++) {
            while (n % d == 0) {
                System.out.println(d);
                n /= d;
            }
        }
        if (n > 1) {
            System.out.println(n);
        }
    }
}
