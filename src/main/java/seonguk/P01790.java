package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        String ans = "-1";
        for (int i = 1; i < 10; i++) {
            long range = (long)(9 * Math.pow(10, i - 1));
            if (k < range * i) {
                int remain = (int)(k % i);
                boolean flag = remain != 0;
                long num = (long) Math.pow(10, i - 1) + k / i - (flag ? 0 : 1);
                if (num <= N) {
                    String str = String.valueOf(num);
                    if (flag) {
                        ans = String.valueOf(str.charAt(remain - 1));
                    } else {
                        ans = String.valueOf(str.charAt(str.length() - 1));
                    }
                }
                break;
            }
            k -= range * i;
        }
        System.out.println(ans);
    }

}
