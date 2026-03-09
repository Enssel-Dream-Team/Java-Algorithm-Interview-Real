package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StickingStickers_18808 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[][][] shapes = new int[k][][];
        int[][] map = new int[n][m];
        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int[][] shape = new int[r][c];
            for (int j = 0; j < r; j++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int l = 0; l < c; l++) {
                    shape[j][l] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            shapes[i] = shape;
        }
        simulation(n, m, k, map, shapes);
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)
                    result++;
            }
        }
        System.out.println(result);
    }

    private static void simulation(int n, int m, int k, int[][] map, int[][][] shapes) {
        for (int shapeIdx = 0; shapeIdx < k; shapeIdx++) {
            int[][] currentShape = shapes[shapeIdx];
            placeShape(map, currentShape);
        }
    }

    private static void placeShape(int[][] map, int[][] currentShape) {
        for (int rotation = 0; rotation < 4; rotation++) {
            int[][] rotatedShape = rotationShape(currentShape, rotation);
            for (int i = 0; i <= map.length - rotatedShape.length; i++) {
                for (int j = 0; j <= map[0].length - rotatedShape[0].length; j++) {
                    if (scanMap(i, j, map, rotatedShape)) {
                        stickingSticker(i, j, map, rotatedShape);
                        return;
                    }
                }
            }
        }
    }

    private static void stickingSticker(int y, int x, int[][] map, int[][] rotatedShape) {
        for (int i = y; i < y + rotatedShape.length; i++) {
            for (int j = x; j < x + rotatedShape[0].length; j++) {
                if (rotatedShape[i - y][j - x] == 1)
                    map[i][j] = 1;
            }

        }
    }

    private static boolean scanMap(int y, int x, int[][] map, int[][] rotatedShape) {
        for (int i = y; i < y + rotatedShape.length; i++) {
            for (int j = x; j < x + rotatedShape[0].length; j++) {
                if (map[i][j] == 1 && rotatedShape[i - y][j - x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotationShape(int[][] currentShape, int rotation) {
        int[][] result = currentShape;
        for (int i = 0; i < rotation; i++) {
            result = rotateCW(result);
        }
        return result;
    }

    private static int[][] rotateCW(int[][] currentShape) {
        int r = currentShape.length;
        int c = currentShape[0].length;
        int[][] rotated = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotated[j][r - i - 1] = currentShape[i][j];
            }
        }
        return rotated;
    }
}
