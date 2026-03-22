package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01700 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] multitab = new int[N];
        int[] things = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            things[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            int idx = findEmpty(multitab, things[i]);
            if (idx > -1) {
                multitab[idx] = things[i];
                continue;
            }

            int rIdx = removeIdx(multitab, things, i);
            multitab[rIdx] = things[i];
            ans++;
        }

        System.out.println(ans);
        br.close();
    }

    private static int removeIdx(int[] multitab, int[] things, int idx) {
        int result = -1;
        int maxVal = 0;

        for (int i = 0; i < N; i++) {
            int thing = multitab[i];
            boolean flag = true;
            for (int j = idx + 1; j < K; j++) {
                if (things[j] == thing) {
                    if (maxVal < j) {
                        maxVal = j;
                        result = i;
                    }
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return result;
    }

    private static int findEmpty(int[] multitab, int thing) {
        for (int i = 0; i < N; i++) {
            if (multitab[i] == 0 || multitab[i] == thing) {
                return i;
            }
        }
        return -1;
    }

}
