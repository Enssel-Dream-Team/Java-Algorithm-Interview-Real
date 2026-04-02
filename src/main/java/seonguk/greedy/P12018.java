package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] milage = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] arr = new int[p];
            st = new StringTokenizer(br.readLine());

            if (p < l) {
                milage[i] = 1;
                continue;
            }

            for (int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            milage[i] = arr[p - l];
        }

        Arrays.sort(milage);
        int i;
        for (i = 0; i < n; i++) {
            m -= milage[i];
            if (m < 0) {
                break;
            }
        }
        System.out.println(i);

        br.close();
    }
}
