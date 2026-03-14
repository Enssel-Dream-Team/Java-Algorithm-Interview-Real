package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16967 {

    static int H, W, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] input = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[H][W];
        init(input, result);
        remain(input, result);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void remain(int[][] input, int[][] result) {
        int maxH = H - X;
        int maxW = W - Y;

        for (int i = 0; i < maxH; i++) {
            for (int j = 0; j < maxW; j++) {
                result[i + X][j + Y] = input[i + X][j + Y] - result[i][j];
            }
        }
    }

    static void init(int[][] input, int[][] result) {
        int maxH = Math.min(H, X);
        int maxW = Math.min(W, Y);

        for (int i = 0; i < maxH; i++) {
            for (int j = 0; j < W; j++) {
                result[i][j] = input[i][j];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < maxW; j++) {
                result[i][j] = input[i][j];
            }
        }
    }
}
