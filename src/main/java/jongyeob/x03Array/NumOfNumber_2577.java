package jongyeob.x03Array;

import java.util.Scanner;

public class NumOfNumber_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] results = solve(A, B, C);
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solve(int a, int b, int c) {
        long multipleResult = (long)a * b * c;
        int[] result = new int[10];
        while (multipleResult != 0) {
            int remainder = (int)multipleResult % 10;
            result[remainder] += 1;
            multipleResult /= 10;
        }
        return result;
    }
}
