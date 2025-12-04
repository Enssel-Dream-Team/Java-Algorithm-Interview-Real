package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollingTheDice_14499 {
    // 0 - 위, 1 - 아래(바닥), 2 - 북, 3 - 남, 4 - 서, 5 - 동
    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private static final int WEST = 4;
    private static final int EAST = 5;
    private static final int[] dice = new int[6];
    private static final int[][] roll = new int[5][4];
    private static final int bottomIndex = 1;
    private static final StringBuilder builder = new StringBuilder();
    private static int[][] map;
    private static int[] rollDirections;
    private static int n, m, x, y, numOfRoll;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        initValue(tokenizer);
        initMap(reader, tokenizer);
        initRollCommand(reader, tokenizer);
        initRollArray();
        simulation();
        System.out.println(builder);
    }

    private static void initValue(StringTokenizer tokenizer) {
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        y = Integer.parseInt(tokenizer.nextToken());
        x = Integer.parseInt(tokenizer.nextToken());
        numOfRoll = Integer.parseInt(tokenizer.nextToken());
        rollDirections = new int[numOfRoll];
    }

    private static void initMap(BufferedReader reader, StringTokenizer tokenizer) throws IOException {
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static void initRollCommand(BufferedReader reader, StringTokenizer tokenizer) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfRoll; i++) {
            rollDirections[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void initRollArray() {
        roll[0] = new int[] {};
        roll[1] = new int[] {TOP, WEST, BOTTOM, EAST};
        roll[2] = new int[] {TOP, EAST, BOTTOM, WEST};
        roll[3] = new int[] {TOP, SOUTH, BOTTOM, NORTH};
        roll[4] = new int[] {TOP, NORTH, BOTTOM, SOUTH};
    }

    private static void simulation() {
        for (int i = 0; i < numOfRoll; i++) {
            int currentDirection = rollDirections[i];
            boolean isMove = moveAndUpdatePosition(currentDirection);
            if (isMove) {
                rollDice(currentDirection);
                updateBottom();
                builder.append(dice[TOP]).append('\n');
            }
        }
    }

    private static void updateBottom() {
        if (map[y][x] != 0) {
            dice[1] = map[y][x];
            map[y][x] = 0;
        } else {
            map[y][x] = dice[1];
        }
    }

    private static boolean moveAndUpdatePosition(int currentDirection) {
        if (currentDirection == 1 && x + 1 < m) {
            x = x + 1;
            return true;
        } else if (currentDirection == 2 && x - 1 >= 0) {
            x = x - 1;
            return true;
        } else if (currentDirection == 3 && y - 1 >= 0) {
            y = y - 1;
            return true;
        } else if (currentDirection == 4 && y + 1 < n) {
            y = y + 1;
            return true;
        }
        return false;
    }

    private static void rollDice(int currentDirection) {
        int[] currentIndexChange = roll[currentDirection];
        int tmp = dice[currentIndexChange[0]];
        dice[currentIndexChange[0]] = dice[currentIndexChange[1]];
        dice[currentIndexChange[1]] = dice[currentIndexChange[2]];
        dice[currentIndexChange[2]] = dice[currentIndexChange[3]];
        dice[currentIndexChange[3]] = tmp;
    }

}
