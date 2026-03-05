package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int centiH = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        boolean flag = false;
        int cnt = 0;
        while (T > 0) {
            int h = pq.poll();
            if (h < centiH) {
                flag = true;
                break;
            }

            T--;
            cnt++;
            pq.add(h / 2 == 0 ? 1 : h / 2);
        }

        if (flag) {
            System.out.println("YES");
            System.out.println(cnt);
        } else {
            int h = pq.poll();
            if (h < centiH) {
                System.out.println("YES");
                System.out.println(cnt);
            } else {
                System.out.println("NO");
                System.out.println(h);
            }
        }
        br.close();
    }
}
