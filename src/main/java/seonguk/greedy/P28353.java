package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P28353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cats = new int[N];
        for (int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);

        int ans = 0;
        int frontIdx = 0;
        int backIdx = N - 1;
        for (; frontIdx < backIdx; frontIdx++) {
            for (; backIdx > frontIdx; backIdx--) {
                if (cats[frontIdx] + cats[backIdx] > K) {
                    continue;
                }

                ans++;
                backIdx--;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
