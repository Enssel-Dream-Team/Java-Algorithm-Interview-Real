package jongyeob.x11Math;

import java.util.Scanner;

public class HoneyComb_2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getDistance(n);
        System.out.println(result);
    }

    private static int getDistance(int n) {
        int sum = 1;
        int step = 1;
        while (sum < n) {
            sum += (step++ * 6);
        }
        return step;
    }
}
