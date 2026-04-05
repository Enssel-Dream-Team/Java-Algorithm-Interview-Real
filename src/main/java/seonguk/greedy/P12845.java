package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P12845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        int val = pq.poll();
        while (!pq.isEmpty()) {
            ans += val + pq.poll();
        }

        System.out.println(ans);
        br.close();
    }
}
