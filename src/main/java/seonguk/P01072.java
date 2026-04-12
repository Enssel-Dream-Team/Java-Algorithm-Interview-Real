package seonguk;

import java.util.Scanner;

public class P01072 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long X = scan.nextLong();
        long Y = scan.nextLong();

        long Z = (Y * 100) / X;
        if (Z >= 99) {
            System.out.println(-1);
        } else {
            long num = (Z + 1) * X - 100 * Y;
            double result = num / (double)(99 - Z);
            if (result % 1 == 0) {
                System.out.println((long) result);
            } else {
                System.out.println((long) result + 1);
            }
        }
    }

}
