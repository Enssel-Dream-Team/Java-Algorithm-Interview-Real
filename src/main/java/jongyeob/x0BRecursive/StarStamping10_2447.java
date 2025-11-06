package jongyeob.x0BRecursive;

import java.util.Scanner;

public class StarStamping10_2447 {
    private static char[][] map;

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        map = new char[N][N];
        stamping(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                builder.append(map[i][j]);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static void stamping(int currentRow, int currentColumn, int mapSize) {
        if (mapSize == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        map[currentRow + i][currentColumn + j] = ' ';
                    } else {
                        map[currentRow + i][currentColumn + j] = '*';
                    }
                }
            }
            return;
        }
        int oneThird = mapSize / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextRow = currentRow + i * oneThird;
                int nextColumn = currentColumn + j * oneThird;
                if (i == 1 && j == 1) {
                    emptyStamping(nextRow, nextColumn, oneThird);
                } else {
                    stamping(nextRow, nextColumn, oneThird);

                }
            }
        }
    }

    private static void emptyStamping(int nextRow, int nextColumn, int oneThird) {
        for (int i = nextRow; i < nextRow + oneThird; i++) {
            for (int j = nextColumn; j < nextColumn + oneThird; j++) {
                map[i][j] = ' ';
            }
        }
    }
}
