package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17829 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N > 1) {
            map = convolution(map);
        }
        System.out.println(map[0][0]);
        br.close();
    }

    static int[][] convolution(int[][] map) {
        N /= 2;
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = second(map, j * 2, i * 2);
            }
        }
        return newMap;
    }

    static int second(int[][] map, int x, int y) {
        int[] arr = new int[4];
        arr[0] = map[y][x];
        arr[1] = map[y][x + 1];
        arr[2] = map[y + 1][x];
        arr[3] = map[y + 1][x + 1];

        Arrays.sort(arr);
        return arr[2];
    }
}
