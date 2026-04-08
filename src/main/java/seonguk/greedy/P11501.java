package seonguk.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class P11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cost = new int[N];
            int[] maxCost = new int[N];
            for (int i = 0; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            maxCost[N - 1] = cost[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (cost[i] > maxCost[i + 1]) {
                    maxCost[i] = cost[i];
                } else {
                    maxCost[i] = maxCost[i + 1];
                }
            }

            long sum = 0;
            int cnt = 0;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (cost[i] < maxCost[i]) {
                    sum += cost[i];
                    cnt++;
                } else {
                    total += (long)maxCost[i] * cnt - sum;
                    sum = 0;
                    cnt = 0;
                }
            }
            bw.write(total + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
