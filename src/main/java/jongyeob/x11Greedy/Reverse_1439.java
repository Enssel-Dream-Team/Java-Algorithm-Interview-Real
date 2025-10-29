package jongyeob.x11Greedy;

import java.util.Scanner;

public class Reverse_1439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();
        int[] groups = new int[2];
        char previous = inputs.charAt(0);
        groups[previous - '0'] = 1;
        for (int i = 1; i < inputs.length(); i++) {
            char current = inputs.charAt(i);
            if (previous != current) {
                groups[current - '0']++;
                previous = current;
            }
        }
        System.out.println(Math.min(groups[0], groups[1]));
    }
}
