package seonguk.implementation;

import java.util.Scanner;

public class P01614 {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        long ans = 0;
        if (n == 1) {
            ans = 8L * m;
        } else if (n == 5) {
            ans = 8L * m + 4;
        } else {
            if (m % 2 == 0) {
                ans = 8L * (m / 2) + n - 1;
            } else {
                ans = 8L * (m / 2) + 9 - n;
            }
        }

        System.out.println(ans);
    }

}
