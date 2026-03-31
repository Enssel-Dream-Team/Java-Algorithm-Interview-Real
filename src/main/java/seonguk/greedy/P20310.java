package seonguk.greedy;

import java.util.Scanner;

public class P20310 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = scan.nextLine().toCharArray();

        int oneCnt = countOne(arr);
        int zeroCnt = arr.length - oneCnt;

        oneCnt /= 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                arr[i] = ' ';
                if (--oneCnt == 0) {
                    break;
                }
            }
        }

        zeroCnt /= 2;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                arr[i] = ' ';
                if (--zeroCnt == 0) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb);
        scan.close();
    }

    static int countOne(char[] arr) {
        int cnt = 0;
        for (char c : arr) {
            if (c == '1') {
                cnt++;
            }
        }

        return cnt;
    }
}
