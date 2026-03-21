package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P05464 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] Rs = new int[N];
        int[] Wk = new int[M + 1];

        Deque<Integer> que = new LinkedList<>();
        int[] fill = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= M; i++) {
            Wk[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * M; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car > 0) {
                int space = emptySpace(fill);
                if (space == -1) {
                    que.addLast(car);
                    continue;
                }

                fill[space] = car;
                ans += Rs[space] * Wk[car];
            } else {
                car *= -1;
                int space = carOut(fill, car);
                if (!que.isEmpty()) {
                    int nextCar = que.pollFirst();
                    fill[space] = nextCar;
                    ans += Rs[space] * Wk[nextCar];
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static int carOut(int[] fill, int car) {
        for (int i = 0; i < fill.length; i++) {
            if (fill[i] == car) {
                fill[i] = 0;
                return i;
            }
        }
        return -1;
    }

    private static int emptySpace(int[] fill) {
        for (int i = 0; i < fill.length; i++) {
            if (fill[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
