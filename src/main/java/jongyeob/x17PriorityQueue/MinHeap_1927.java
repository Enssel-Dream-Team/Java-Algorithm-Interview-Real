package jongyeob.x17PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinHeap_1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                if (pq.isEmpty()) {
                    builder.append('0');
                } else {
                    builder.append(pq.poll());
                }
                builder.append('\n');
            } else {
                pq.add(n);
            }
        }
        writer.append(builder);
        writer.flush();
    }
}
