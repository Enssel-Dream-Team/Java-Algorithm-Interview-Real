package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WizardSharkAndTheRaindrop_21610 {
    private static int N, M, movedX, movedY;
    private static int[][] map, cloud;
    private static CloudMove[] moves;
    private static int[][] directions = new int[][] {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0},
        {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][N];
        cloud = new int[N][N];
        moves = new CloudMove[M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            moves[i] = new CloudMove(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
        simulation();
        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    private static void simulation() {
        initCloud();
        for (int i = 0; i < M; i++) {
            CloudMove currentMove = moves[i];
            moveCloud(currentMove);
            rain();
            removeCloud();
            waterCopyBug();
            makeCloud();
        }
    }

    private static void initCloud() {
        cloud[N - 1][0] = 1;
        cloud[N - 1][1] = 1;
        cloud[N - 2][0] = 1;
        cloud[N - 2][1] = 1;
    }

    private static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    if (cloud[i][j] == 0) {
                        map[i][j] -= 2;
                        cloud[i][j] = 1;
                    } else {
                        cloud[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void waterCopyBug() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j] != -1)
                    continue;
                int[][] nearPosition = new int[][] {{i + 1, j - 1}, {i + 1, j + 1}, {i - 1, j + 1}, {i - 1, j - 1}};
                int nearWaterField = 0;
                for (int[] position : nearPosition) {
                    if (position[0] >= 0 && position[0] < N && position[1] >= 0 && position[1] < N) {
                        if (map[position[0]][position[1]] > 0)
                            nearWaterField++;
                    }
                }
                map[i][j] += nearWaterField;
            }
        }
    }

    private static void removeCloud() {
        int[][] newCloud = new int[N][N];
        for (int i = 0; i < N; i++) {
            int y = (movedY + i + N) % N;
            for (int j = 0; j < N; j++) {
                int x = (movedX + j + N) % N;
                if (cloud[i][j] == 1) {
                    newCloud[y][x] = -1;
                }
            }
        }
        cloud = newCloud;
        movedX = 0;
        movedY = 0;
    }

    private static void rain() {
        for (int i = 0; i < N; i++) {
            int y = (movedY + i + N) % N;
            for (int j = 0; j < N; j++) {
                int x = (movedX + j + N) % N;
                if (cloud[i][j] == 1)
                    map[y][x]++;
            }
        }
    }

    private static void moveCloud(CloudMove currentMove) {
        int[] direction = directions[currentMove.direction - 1];
        movedY = (direction[0] * currentMove.distance) % N;
        movedX = (direction[1] * currentMove.distance) % N;

    }

    private static class CloudMove {
        int direction;
        int distance;

        public CloudMove(int direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
}
