package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16931 {

    static int N, M;
    static int[][] blocks;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blocks = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += calcSurface(j, i);
            }
        }

        System.out.println(ans);
        br.close();
    }

    static int calcSurface(int x, int y) {
        int sum = 2;
        if (x == 0) {
            sum += blocks[y][x];
        }
        if (y == 0) {
            sum += blocks[y][x];
        }
        if (x == M - 1) {
            sum += blocks[y][x];
        }
        if (y == N - 1) {
            sum += blocks[y][x];
        }

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];
            if (fx >= 0 && fx < M && fy >= 0 && fy < N) {
                int temp = blocks[y][x] - blocks[fy][fx];
                if (temp > 0) {
                    sum += temp;
                }
            }
        }
        return sum;
    }
}
