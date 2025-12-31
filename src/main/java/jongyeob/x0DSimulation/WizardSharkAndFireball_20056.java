package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WizardSharkAndFireball_20056 {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1},
        {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        List<Fireball>[][] initFireball = initFireballList(n);
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            initFireball[Integer.parseInt(tokenizer.nextToken()) - 1][Integer.parseInt(tokenizer.nextToken()) - 1].add(
                new Fireball(Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }
        int result = simulation(n, k, initFireball);
        System.out.println(result);
    }

    private static int simulation(int mapSize, int iteration, List<Fireball>[][] fireballs) {
        List<Fireball>[][] fireballsEven = fireballs;
        List<Fireball>[][] fireballsOdd = initFireballList(mapSize);
        for (int i = 0; i < iteration; i++) {
            List<Fireball>[][] moveResult = moveFireball(mapSize, i % 2 == 0 ? fireballsEven : fireballsOdd,
                i % 2 == 0 ? fireballsOdd : fireballsEven);
            checkFlip(mapSize, moveResult);
        }
        int totalMass = sumMass(mapSize, iteration % 2 == 0 ? fireballsEven : fireballsOdd);
        return totalMass;
    }

    private static int sumMass(int mapSize, List<Fireball>[][] map) {
        int result = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                List<Fireball> currentList = map[i][j];
                if (currentList.isEmpty())
                    continue;
                for (Fireball fireball : currentList) {
                    result += fireball.mass;
                }
            }
        }
        return result;
    }

    private static void checkFlip(int mapSize, List<Fireball>[][] map) {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                List<Fireball> currentList = map[y][x];
                if (currentList.isEmpty() || currentList.size() == 1)
                    continue;
                int flipCount = currentList.size();
                int totalMass = 0;
                int totalSpeed = 0;
                boolean isAllOdd = true;
                boolean isAllEven = true;
                for (Fireball fireball : currentList) {
                    totalMass += fireball.mass;
                    totalSpeed += fireball.speed;
                    if (fireball.direction % 2 == 0) {
                        isAllOdd = false;
                    } else {
                        isAllEven = false;
                    }
                }
                currentList.clear();
                int newMass = totalMass / 5;
                int newSpeed = totalSpeed / flipCount;
                if (newMass == 0)
                    continue;
                if (isAllOdd || isAllEven) {
                    currentList.add(new Fireball(newMass, newSpeed, 0));
                    currentList.add(new Fireball(newMass, newSpeed, 2));
                    currentList.add(new Fireball(newMass, newSpeed, 4));
                    currentList.add(new Fireball(newMass, newSpeed, 6));
                } else {
                    currentList.add(new Fireball(newMass, newSpeed, 1));
                    currentList.add(new Fireball(newMass, newSpeed, 3));
                    currentList.add(new Fireball(newMass, newSpeed, 5));
                    currentList.add(new Fireball(newMass, newSpeed, 7));
                }
            }
        }
    }

    private static List<Fireball>[][] initFireballList(int mapSize) {
        List<Fireball>[][] fireballs = new List[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                fireballs[i][j] = new ArrayList<>();
            }
        }
        return fireballs;
    }

    private static List<Fireball>[][] moveFireball(int mapSize, List<Fireball>[][] target,
        List<Fireball>[][] destination) {
        for (int currentY = 0; currentY < mapSize; currentY++) {
            for (int currentX = 0; currentX < mapSize; currentX++) {
                List<Fireball> currentList = target[currentY][currentX];
                if (currentList.isEmpty())
                    continue;
                for (Fireball fireball : currentList) {
                    int[] direction = DIRECTIONS[fireball.direction];
                    int nextY = (currentY + (direction[0] * fireball.speed) % mapSize + mapSize) % mapSize;
                    int nextX = (currentX + (direction[1] * fireball.speed) % mapSize + mapSize) % mapSize;
                    destination[nextY][nextX].add(fireball);
                }
                currentList.clear();
            }
        }
        return destination;
    }

    private static class Fireball {
        int mass;
        int speed;
        int direction;

        public Fireball(int mass, int speed, int direction) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
}
