package jongyeob.x17PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteValueHeap_11286 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<OriginInput> pq = new PriorityQueue<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                if (pq.isEmpty()) {
                    builder.append("0");
                } else {
                    builder.append(pq.poll().real);
                }
                builder.append('\n');
            } else {
                pq.add(new OriginInput(Math.abs(n), n));
            }
        }
        System.out.println(builder);
    }

    private static class OriginInput implements Comparable<OriginInput> {
        int abs;
        int real;

        public OriginInput(int abs, int real) {
            this.abs = abs;
            this.real = real;
        }

        @Override
        public int compareTo(OriginInput other) {
            return this.abs == other.abs ? Integer.compare(this.real, other.real) :
                Integer.compare(this.abs, other.abs);
        }
    }
}
