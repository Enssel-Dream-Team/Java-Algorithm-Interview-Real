package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P06986 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);

        System.out.printf("%.2f\n", trimmedAvg(arr, K));
        System.out.printf("%.2f", calibratedAvg(arr, K));
    }

    static double trimmedAvg(double[] arr, int K) {
        double sum = 0;
        for (int i = K; i < N - K; i++) {
            sum += arr[i];
        }
        return calc(sum, N - 2 * K);
    }

    static double calibratedAvg(double[] arr, int K) {
        double sum = 0;
        sum += arr[K] * (K + 1);
        for (int i = K + 1; i < N - K - 1; i++) {
            sum += arr[i];
        }
        sum += arr[N - K - 1] * (K + 1);
        return calc(sum, N);
    }

    static double calc(double num, int cnt) {
        int val = (int)(num * 1000);
        val /= cnt;
        if (val % 10 < 5) {
            val /= 10;
        } else {
            val /= 10;
            val += 1;
        }
        return (double) val / 100;
    }

}
