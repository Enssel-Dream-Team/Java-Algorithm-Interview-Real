package jongyeob.x0BRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeColoredPaper_2630 {
    private static final int[] results = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        recursive(map, 0, 0, map.length);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    private static void recursive(int[][] map, int x, int y, int n) {
        // 탐색
        boolean isSame = checkSame(map, x, y, n);
        // 자르기
        if (!isSame) {
            int size = n / 2;
            for (int k = 0; k < 2; k++) {
                for (int t = 0; t < 2; t++) {
                    recursive(map, t * size + x, k * size + y, size);
                }
            }
        } else { // 개수 추가
            results[map[x][y]] += 1;
        }
    }

    private static boolean checkSame(int[][] map, int x, int y, int n) {
        boolean isSame = true;
        int benchmark = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (benchmark != map[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame)
                break;
        }
        return isSame;
    }
}
