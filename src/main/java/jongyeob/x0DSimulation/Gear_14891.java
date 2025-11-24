package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gear_14891 {
    private static int[][] gears = new int[4][8];
    private static int[] gearStartIndexes = new int[4];
    private static boolean[] alreadyTurning = new boolean[4];
    private static Turning[] turing;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String gearInput = reader.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = gearInput.charAt(j) - '0';
            }
        }
        int N = Integer.parseInt(reader.readLine());
        turing = new Turning[N];
        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            turing[i] = new Turning(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]));
        }

        for (int i = 0; i < N; i++) {
            turnGear(turing[i]);
        }
        int result = 0;
        if (gears[0][gearStartIndexes[0]] == 1)
            result += 1;
        if (gears[1][gearStartIndexes[1]] == 1)
            result += 2;
        if (gears[2][gearStartIndexes[2]] == 1)
            result += 4;
        if (gears[3][gearStartIndexes[3]] == 1)
            result += 8;
        System.out.println(result);
    }

    private static void turnGear(Turning turning) {
        int targetGearIndex = turning.gearIndex;
        int leftGearPoint = (gearStartIndexes[targetGearIndex] + 6) % 8;
        int rightGearPoint = (gearStartIndexes[targetGearIndex] + 2) % 8;
        int[] gear = gears[turning.gearIndex];
        alreadyTurning[targetGearIndex] = true;
        int leftGearIndex = targetGearIndex - 1;
        if (leftGearIndex > -1 && gear[leftGearPoint] != gears[leftGearIndex][(gearStartIndexes[leftGearIndex] + 2)
            % 8]) {
            if (!alreadyTurning[leftGearIndex])
                turnGear(new Turning(leftGearIndex, turning.direction * -1));
        }
        int rightGearIndex = turning.gearIndex + 1;
        if (rightGearIndex < 4 && gear[rightGearPoint] != gears[rightGearIndex][(gearStartIndexes[rightGearIndex] + 6)
            % 8]) {
            if (!alreadyTurning[rightGearIndex])
                turnGear(new Turning(rightGearIndex, turning.direction * -1));
        }
        if (turning.direction == -1) {
            gearStartIndexes[targetGearIndex] = (gearStartIndexes[targetGearIndex] + 1) % 8;
        } else {
            gearStartIndexes[targetGearIndex] = (gearStartIndexes[targetGearIndex] - 1 + 8) % 8;
        }
        alreadyTurning[targetGearIndex] = false;
    }

    private static class Turning {
        int gearIndex;
        int direction;

        public Turning(int gearIndex, int direction) {
            this.gearIndex = gearIndex;
            this.direction = direction;
        }
    }
}
