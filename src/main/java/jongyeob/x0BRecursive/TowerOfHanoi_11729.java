package jongyeob.x0BRecursive;

import java.util.Scanner;

public class TowerOfHanoi_11729 {
    private static final StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = hanoi(N, 1, 3, 2);
        System.out.println(builder.insert(0, result + "\n"));
    }

    private static int hanoi(int n, int origin, int destiny, int sub) {
        if (n == 1) {
            builder.append(origin).append(' ').append(destiny).append('\n');
            return 1;
        }
        int result = 0;
        result += hanoi(n - 1, origin, sub, destiny);
        result += hanoi(1, origin, destiny, sub);
        result += hanoi(n - 1, sub, destiny, origin);
        return result;
    }
}
