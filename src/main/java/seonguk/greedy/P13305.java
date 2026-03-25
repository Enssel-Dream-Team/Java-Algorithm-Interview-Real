package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distances = new int[N - 1];
        int[] prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = prices[0];
        int idx = 0;
        long total = 0;
        for (int i = 1; i < N; i++) {
            if (prices[i] < minPrice) {
                int dist = 0;
                for (int j = idx; j < i; j++) {
                    dist += distances[j];
                }
                total += (long) dist * minPrice;
                idx = i;
                minPrice = prices[i];
            }
        }

        int dist = 0;
        for (int j = idx; j < N - 1; j++) {
            dist += distances[j];
        }

        total += (long) dist * minPrice;
        System.out.println(total);

        br.close();
    }
}
