package jongyeob.x0BRecursive;

import java.util.Scanner;

public class StarStamping11_2448 {
    private static char[][] map;
    private static final char[][] stars = {
        {' ', ' ', '*', ' ', ' '},
        {' ', '*', ' ', '*', ' '},
        {'*', '*', '*', '*', '*'}
    };

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int width = N * 2 - 1;
        map = new char[N][width];

        initMap(N, width);
        stamping(0, N - 1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(map[i][j]);
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }

    private static void stamping(int currentRow, int currentColumn, int height) {
        if (height == 3) {
            int startColumn = currentColumn - 2;
            for (int i = 0; i < 3; i++) {
                System.arraycopy(stars[i], 0, map[currentRow + i], startColumn + 0, 5);
            }
        } else {
            int halfHeight = height / 2;
            stamping(currentRow, currentColumn, halfHeight);
            stamping(currentRow + halfHeight, currentColumn - halfHeight, halfHeight);
            stamping(currentRow + halfHeight, currentColumn + halfHeight, halfHeight);
        }

    }

    private static void initMap(int N, int width) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < width; j++)
                map[i][j] = ' ';
    }
}
