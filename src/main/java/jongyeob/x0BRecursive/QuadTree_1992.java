package jongyeob.x0BRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree_1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String inputs = reader.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = inputs.charAt(j) - '0';
            }
        }

        String result = quadTree(map, 0, 0, N);
        System.out.println(result);
    }

    private static String quadTree(int[][] map, int x, int y, int width) {
        // Scan
        boolean isSame = checkSame(map, x, y, width);
        // Divide
        if (isSame) {
            return String.valueOf(map[x][y]);
        } else {
            String result = "";
            int nextWidth = width / 2;
            result += "(";
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    result = result + quadTree(map, x + (i * nextWidth), y + (j * nextWidth), nextWidth);
                }
            }
            result += ")";
            return result;
        }

    }

    private static boolean checkSame(int[][] map, int x, int y, int width) {
        int target = map[x][y];
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + width; j++) {
                if (map[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
