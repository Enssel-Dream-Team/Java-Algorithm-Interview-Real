package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02824 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        fillArray(arrN, new StringTokenizer(br.readLine()));

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        fillArray(arrM, new StringTokenizer(br.readLine()));

        long ans = 1;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrN[i] == 1) {
                    break;
                }
                if (arrM[j] == 1) {
                    continue;
                }

                int gcd = gcd(arrN[i], arrM[j]);
                arrN[i] /= gcd;
                arrM[j] /= gcd;
                ans *= gcd;
                if (ans >= 1000_000_000) {
                    flag = true;
                    ans %= 1_000_000_000;
                }
            }
        }
        String result = String.valueOf(ans);
        if (flag) {
            result = "0".repeat(9 - result.length()) + result;
        }
        System.out.println(result);
        br.close();
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void fillArray(int[] arr, StringTokenizer st) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
