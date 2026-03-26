package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
                for (int j = start; j <= end; j++) {
                    if (arr[j] == 'H' && !visited[j]) {
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
