package jongyeob.x11Math;

import java.util.Scanner;

public class MathIsPhysicalSubject_15894 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long result = solve(scanner.nextInt());
        System.out.println(result);
    }

    private static long solve(int depth) {
        return depth * 4L;
    }
}
