package jongyeob.x0BRecursive;

import java.util.Scanner;

public class Multiplication_1629 {
    private static long A, B, C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextLong();
        B = scanner.nextLong();
        C = scanner.nextLong();
        long result = recursive(B);
        System.out.println(result);
    }

    private static long recursive(long i) {
        if (i == 0)
            return 1 % C;
        long half = recursive(i / 2);
        long result = (half * half) % C;
        if (i % 2 == 1)
            result = (result * A) % C;
        return result;
    }
}
