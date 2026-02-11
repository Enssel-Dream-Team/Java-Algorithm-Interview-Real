package jongyeob.x11Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KaingCalendar_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int tc = Integer.parseInt(tokenizer.nextToken());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            long lcm = getLCM(m, n);
            long result = calculateYear(lcm, m, n, x, y);
            builder.append(result).append('\n');
        }
        System.out.println(builder);
    }

    private static long calculateYear(long lcm, int m, int n, int x, int y) {
        long year = x;
        while (year <= lcm) {
            if (year % n == y || (year % n == 0 && y == n)) {
                return year;
            } else {
                year += m;
            }
        }
        return -1;
    }

    private static long getLCM(int m, int n) {
        return (long)m / getGCD(m, n) * n;
    }

    private static int getGCD(int m, int n) {
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

}
