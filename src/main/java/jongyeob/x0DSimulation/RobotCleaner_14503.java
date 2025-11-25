package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {
    private static int N, M;
    private static int robotX, robotY, robotDirection;
    private static int[][] map;
    private static int[][] direction = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static int cleaningCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];
        tokenizer = new StringTokenizer(reader.readLine());
        robotY = Integer.parseInt(tokenizer.nextToken());
        robotX = Integer.parseInt(tokenizer.nextToken());
        robotDirection = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        simulation();
        System.out.println(cleaningCount);
    }

    private static void simulation() {
        while (true) {
            checkCleaned();
            boolean doCleaning = false;
            for (int i = 1; i < 5; i++) {
                int nextDirection = (robotDirection - i + 4) % 4;
                int nextX = robotX + direction[nextDirection][0];
                int nextY = robotY + direction[nextDirection][1];
                if (nextX > -1 && nextX < M && nextY > -1 && nextY < N && map[nextY][nextX] == 0) {
                    robotX = nextX;
                    robotY = nextY;
                    robotDirection = nextDirection;
                    doCleaning = true;
                    break;
                }
            }
            if (!doCleaning) {
                int beforeX = robotX - direction[robotDirection][0];
                int beforeY = robotY - direction[robotDirection][1];
                if (map[beforeY][beforeX] == 1)
                    break;
                else {
                    robotX = beforeX;
                    robotY = beforeY;
                }

            }
        }
    }

    private static void checkCleaned() {
        if (map[robotY][robotX] == 0) {
            map[robotY][robotX] = -1;
            cleaningCount++;
        }
    }
}
