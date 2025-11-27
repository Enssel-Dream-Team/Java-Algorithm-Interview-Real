package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotOnConveyor_20055 {
    private static int N, K;
    private static int numOfZero = 0;
    private static int startPosition = 0;
    private static int[] conveyor, robots;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        conveyor = new int[2 * N];
        robots = new int[2 * N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 2 * N; i++) {
            conveyor[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        int count = 0;
        while (numOfZero < K) {
            turnConveyor();
            moveRobots();
            if (conveyor[startPosition] > 0 && robots[startPosition] != 1) {
                conveyor[startPosition]--;
                robots[startPosition] = 1;
            }
            count++;
            numOfZero = countZeroBelt();
        }
        return count;
    }

    private static int countZeroBelt() {
        int count = 0;
        for (int i : conveyor) {
            if (i == 0)
                count++;
        }
        return count;
    }

    private static void moveRobots() {
        int unloadPosition = (startPosition + N - 1) % (2 * N);
        for (int i = N - 2; i > -1; i--) {
            int offset = (startPosition + i) % (2 * N);
            if (robots[offset] == 0)
                continue;
            int nextPosition = (offset + 1) % (2 * N);
            if (conveyor[nextPosition] > 0 && robots[nextPosition] == 0) {
                robots[offset] = 0;
                conveyor[nextPosition]--;
                if (nextPosition != unloadPosition) {
                    robots[nextPosition] = 1;
                }
            }
        }
    }

    private static void turnConveyor() {
        startPosition = (startPosition - 1 + (2 * N)) % (2 * N);
        if (robots[(startPosition + N - 1) % (2 * N)] == 1)
            robots[(startPosition + N - 1) % (2 * N)] = 0;
    }
}
