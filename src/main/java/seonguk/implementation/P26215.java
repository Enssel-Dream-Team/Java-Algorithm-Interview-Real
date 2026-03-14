package seonguk.implementation;

import java.util.*;

public class P26215 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        if (n > 1) {
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    break;
                }

                int num1 = pq.poll() - 1;
                int num2 = pq.poll() - 1;
                if (num1 > 0) {
                    pq.add(num1);
                }
                if (num2 > 0) {
                    pq.add(num2);
                }
                result++;
            }
        }
        if (!pq.isEmpty()) {
            result += pq.poll();
        }

        if (result > 1440) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        scan.close();
    }

}
