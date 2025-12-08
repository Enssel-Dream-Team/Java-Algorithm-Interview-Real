package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {
    private static int[][][] shapes = new int[][][] {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // ㅡ
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // |
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
        {{0, 0}, {0, 1}, {1, 1}, {0, 2}}, // ㅜ
        {{0, 0}, {0, 1}, {-1, 1}, {0, 2}}, // ㅗ
        {{0, 0}, {1, 0}, {1, 1}, {2, 0}}, // ㅏ
        {{0, 0}, {1, 0}, {1, -1}, {2, 0}}, // ㅓ
        {{0, 1}, {0, 2}, {1, 0}, {1, 1}}, // S 가로
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // S 세로
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // Z 가로
        {{0, 1}, {1, 0}, {1, 1}, {2, 0}}, // Z 세로
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},   // 가로 L (아래 오른쪽)
        {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},  // 가로 L (위 오른쪽)
        {{-1, 0}, {0, 0}, {0, 1}, {0, 2}},  // 가로 J (위 왼쪽)
        {{1, 0}, {0, 0}, {0, 1}, {0, 2}},   // 가로 J (아래 왼쪽)
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},   // 세로 L (아래 오른쪽)
        {{0, 0}, {1, 0}, {2, 0}, {0, 1}},   // 세로 L (위 오른쪽)
        {{0, 1}, {1, 1}, {2, 1}, {2, 0}},   // 세로 J (아래 왼쪽)
        {{0, 1}, {1, 1}, {2, 1}, {0, 0}},   // 세로 J (위 왼쪽)
    };
    private static int n, m;
    private static int[][] map;
    private static int maxTetromino = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        simulation();
        System.out.println(maxTetromino);
    }

    private static void simulation() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                for (int[][] shape : shapes) {
                    int sum = 0;
                    try {
                        for (int i = 0; i < 4; i++) {
                            int nextY = y + shape[i][0];
                            int nextX = x + shape[i][1];
                            sum += map[nextY][nextX];
                        }
                    } catch (Exception e) {
                        continue;
                    }
                    maxTetromino = Math.max(maxTetromino, sum);
                }
            }
        }
    }
}
