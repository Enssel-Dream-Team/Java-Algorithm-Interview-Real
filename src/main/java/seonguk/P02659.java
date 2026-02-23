package seonguk;

import java.util.Scanner;

public class P02659 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");

        String clockNum = findClockNum(arr);
        System.out.println(findRank(clockNum));
        scan.close();
    }

    static int findRank(String str) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = '1'; i <= '9'; i++) {
            sb.append((char) i);
            for (int j = i; j <= '9'; j++) {
                sb.append((char) j);
                for (int k = j; k <= '9'; k++) {
                    sb.append((char) k);
                    for (int l = k; l <= '9'; l++) {
                        sb.append((char) l);
                        if (str.equals(sb.toString())) {
                            return cnt;
                        }
                        cnt++;
                        sb.deleteCharAt(3);
                    }
                    sb.deleteCharAt(2);
                }
                sb.deleteCharAt(1);
            }
            sb.deleteCharAt(0);
        }
        return -1;
    }

    static String findClockNum(String[] arr) {
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                sb.append(arr[(j + i) % 4]);
            }
            num = Math.min(num, Integer.parseInt(sb.toString()));
        }
        return String.valueOf(num);
    }
}
