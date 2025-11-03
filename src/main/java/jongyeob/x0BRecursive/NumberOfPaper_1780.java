package jongyeob.x0BRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfPaper_1780 {
    private static final int[] results = new int[3]; // 0 => 0, 1 => 1, 2 => -1

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
        recursive(map);
        System.out.println(results[2]);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    private static void recursive(int[][] map) {
        // 탐색
        boolean isSame = checkSame(map);
        // 자르기
        if (!isSame) {
            int size = map.length / 3;
            for (int k = 0; k < 3; k++) {
                for (int t = 0; t < 3; t++) {
                    int[][] tempMap = new int[size][size];
                    for (int i = 0; i < size; i++) {
                        System.arraycopy(map[k * size + i], t * size, tempMap[i], 0, size);
                    }
                    recursive(tempMap);
                }
            }
        } else { // 개수 추가
            if (map[0][0] == -1) {
                results[2] += 1;
            } else {
                results[map[0][0]] += 1;
            }
        }
    }

    private static boolean checkSame(int[][] map) {
        boolean isSame = true;
        int benchmark = map[0][0];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
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
