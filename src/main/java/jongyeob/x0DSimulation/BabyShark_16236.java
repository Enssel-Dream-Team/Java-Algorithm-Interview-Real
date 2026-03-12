package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark_16236 {
    private static final int[] dy = new int[] {-1, 1, 0, 0};
    private static final int[] dx = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][n];
        Fish babyShark = null;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value == 9)
                    babyShark = new Fish(i, j, 2, 0);
                else
                    map[i][j] = value;
            }
        }
        int result = simulation(n, map, babyShark);
        System.out.println(result);
    }

    private static int simulation(int n, int[][] map, Fish babyShark) {
        int time = 0;
        int eatCount = 0;
        while (true) {
            int[] targetPos = scanFish(n, map, babyShark);
            if (targetPos[0] == n && targetPos[1] == n) {
                break;
            }
            eatFish(map, babyShark, targetPos);
            eatCount++;
            if (babyShark.size == eatCount) {
                eatCount = 0;
                babyShark.size += 1;
            }
            time += targetPos[2];
        }
        return time;
    }

    private static void eatFish(int[][] map, Fish babyShark, int[] targetPos) {
        babyShark.y = targetPos[0];
        babyShark.x = targetPos[1];
        map[targetPos[0]][targetPos[1]] = 0;
    }

    private static int[] scanFish(int n, int[][] map, Fish babyShark) {
        boolean[][] visited = new boolean[n][n];
        Queue<Fish> queue = new ArrayDeque<>();
        queue.add(new Fish(babyShark.y, babyShark.x, 0, 0));
        visited[babyShark.y][babyShark.x] = true;
        int targetY = n;
        int targetX = n;
        int maxLength = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Fish currentFish = queue.poll();
            if (currentFish.distance > maxLength) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentFish.y + dy[i];
                int nextX = currentFish.x + dx[i];
                int nextDistance = currentFish.distance + 1;
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    if (map[nextY][nextX] != 0 && map[nextY][nextX] < babyShark.size && nextDistance <= maxLength) {
                        if (nextDistance < maxLength) {
                            maxLength = nextDistance;
                            targetY = nextY;
                            targetX = nextX;
                        } else {
                            if (targetY > nextY) {
                                targetY = nextY;
                                targetX = nextX;
                            } else if (targetY == nextY) {
                                targetX = Math.min(targetX, nextX);
                            }
                        }
                        queue.add(new Fish(nextY, nextX, 0, nextDistance));
                    } else if (map[nextY][nextX] == 0 || map[nextY][nextX] == babyShark.size) {
                        queue.add(new Fish(nextY, nextX, 0, nextDistance));

                    }
                }
            }
        }
        int[] target = new int[3];
        target[0] = targetY;
        target[1] = targetX;
        target[2] = maxLength;
        return target;
    }

    private static class Fish {
        int y;
        int x;
        int size;
        int distance;

        public Fish(int y, int x, int size, int distance) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.distance = distance;
        }
    }
}