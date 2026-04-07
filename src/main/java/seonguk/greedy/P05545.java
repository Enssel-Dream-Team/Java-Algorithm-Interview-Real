package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P05545 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(D);
        int total = C;
        int cost = A;
        for (int i = N - 1; i >= 0; i--) {
            if ((double) (total + D[i]) / (cost + B) <= (double)total / cost) {
                break;
            }
            total += D[i];
            cost += B;
        }

        System.out.println(total / cost);
    }
}
