package jongyeob.x10DP;

import java.util.Scanner;

public class TheaterSeats_2302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int numOfVip = scanner.nextInt();
        long[] seatWays = new long[N + 1];
        int[] vipIndexes = new int[numOfVip];
        for (int i = 0; i < numOfVip; i++) {
            vipIndexes[i] = scanner.nextInt();
        }
        seatWays[0] = 1; // 연속된 구간은 계산 시 0이 나옴
        seatWays[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            seatWays[i] = seatWays[i - 1] + seatWays[i - 2];
        }
        long result = 1;
        int previous = 0;
        for (int i = 0; i < vipIndexes.length; i++) {
            int gap = vipIndexes[i] - previous - 1;
            previous = vipIndexes[i];
            result *= seatWays[gap];
        }
        result *= seatWays[N - previous];
        System.out.println(result);
    }
}
