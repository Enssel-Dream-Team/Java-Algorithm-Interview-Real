package jongyeob.x0BRecursive;

import java.util.Scanner;

public class Z_1074 {
    private static int r, c;
    private static int calculateCount = 0;
    private static int[][] map = new int[2][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int mapSize = (int)Math.pow(2, N);
        r = scanner.nextInt();
        c = scanner.nextInt();
        int result = zScannerMap(0, 0, mapSize);
        System.out.println(result);
    }

    private static int zScannerMap(int currentRow, int currentColumn, int mapSize) {
        if (mapSize == 2) {
            int norm = calculateCount * 4;
            map[0][0] = norm;
            map[0][1] = 1 + norm;
            map[1][0] = 2 + norm;
            map[1][1] = 3 + norm;
            int rowIndex = (currentRow != 0) ? (r % currentRow) : r;
            int colIndex = (currentColumn != 0) ? (c % currentColumn) : c;
            return map[rowIndex][colIndex];
        }
        int halfSize = mapSize / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int nextRow = currentRow + i * halfSize;
                int nextColumn = currentColumn + j * halfSize;
                if (r >= nextRow && r < nextRow + halfSize && c >= nextColumn && c < nextColumn + halfSize)
                    return zScannerMap(nextRow, nextColumn, halfSize);
                calculateCount += halfSize * halfSize / 4; // 해당 분면의 모든 2/2 배열을 스킵하기 때문에
            }
        }
        return 0;
    }
}
