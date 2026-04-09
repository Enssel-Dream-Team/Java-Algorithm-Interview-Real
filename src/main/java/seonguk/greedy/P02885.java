package seonguk.greedy;

import java.util.Scanner;

public class P02885 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();

        String str = Integer.toBinaryString(K);
        int check = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                check++;
            }
        }

        if (check == 1) {
            System.out.println(K + " " + 0);
            return;
        }

        String size = "1" + "0".repeat(str.length());
        int result = Integer.parseInt(size, 2);

        int cnt = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                break;
            }
            cnt--;
        }

        System.out.println(result + " " + cnt);
    }
}
