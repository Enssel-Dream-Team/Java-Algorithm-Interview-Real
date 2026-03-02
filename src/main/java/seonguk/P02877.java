package seonguk;

import java.util.Scanner;

public class P02877 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Result r = calcSize(n);
        String str = toBinary(r.remain - 1);
        str = "0".repeat(r.size - str.length()) + str;
        System.out.println(str.replace("0", "4").replace("1", "7"));
        scan.close();
    }

    static String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    static Result calcSize(int num) {
        int sum = 0;
        int cnt = 0;
        int result = num;

        while (num > sum) {
            int temp = (int) Math.pow(2, ++cnt);
            sum += temp;
            if (num > sum) {
                result -= temp;
            }
        }
        return new Result(cnt, result);
    }

    static class Result {
        int size;
        int remain;

        public Result(int size, int remain) {
            this.size = size;
            this.remain = remain;
        }
    }
}
