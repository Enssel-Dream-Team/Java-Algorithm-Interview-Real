package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            arr[N - 1] += arr[i] / 2;
        }

        if (arr[N - 1] % 1 == 0) {
            System.out.println((long) arr[N - 1]);
        } else {
            System.out.println(arr[N - 1]);
        }
        br.close();
    }
}
