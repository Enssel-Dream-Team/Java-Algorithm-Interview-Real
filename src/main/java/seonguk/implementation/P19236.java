package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P19236 {

    static int ans = 0;
    static final int[] DX = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] map = new Fish[4][4];
        PriorityQueue<Fish> pq = new PriorityQueue<>();

        Shark shark = setInit(br, map, pq);

        recursion(shark, map, pq);
        System.out.println(ans);
        br.close();
    }

    private static void recursion(Shark shark, Fish[][] map, PriorityQueue<Fish> pq) {
        while (!pq.isEmpty()) {
            Fish fish = pq.poll();
            map[fish.y][fish.x].move(map, shark);
        }

        List<Point> points = shark.locationList(map);
        if (points.isEmpty()) {
            ans = Math.max(ans, shark.amount);
            return;
        }

        for (Point point : points) {
            Fish[][] nextMap = copyMap(map);
            Shark nextShark = shark.copy();
            nextShark.eatFish(point.x, point.y, nextMap);
            PriorityQueue<Fish> nextPq = setPq(nextMap);
            recursion(nextShark, nextMap, nextPq);
        }
    }

    private static PriorityQueue<Fish> setPq(Fish[][] map) {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        for (Fish[] fishes : map) {
            for (Fish fish : fishes) {
                if (fish != null) {
                    pq.add(fish);
                }
            }
        }
        return pq;
    }

    private static Fish[][] copyMap(Fish[][] map) {
        Fish[][] copyMap = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] != null) {
                    copyMap[i][j] = map[i][j].copy();
                }
            }
        }
        return copyMap;
    }

    private static Shark setInit(BufferedReader br, Fish[][] map, PriorityQueue<Fish> pq) throws IOException {
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                Fish fish = new Fish(a, b, j, i);
                map[i][j] = fish;
            }
        }
        Shark shark = new Shark(map);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] != null) {
                    pq.add(map[i][j]);
                }
            }
        }
        return shark;
    }

    static class Shark {
        int x, y;
        int dir;
        int amount;

        public Shark(Fish[][] map) {
            this.x = 0;
            this.y = 0;

            Fish fish = map[0][0];
            this.dir = fish.dir;
            this.amount = fish.num;
            map[0][0] = null;
        }

        private Shark(int x, int y, int dir, int amount) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.amount = amount;
        }

        public List<Point> locationList(Fish[][] map) {
            List<Point> pointList = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                int fx = x + DX[dir] * i;
                int fy = y + DY[dir] * i;
                if (fx >= 0 && fx < 4 && fy >= 0 && fy < 4 && map[fy][fx] != null) {
                    pointList.add(new Point(fx, fy));
                }
            }
            return pointList;
        }

        public void eatFish(int x, int y, Fish[][] map) {
            Fish fish = map[y][x];
            amount += fish.num;
            dir = fish.dir;
            map[y][x] = null;
            this.x = x;
            this.y = y;
        }

        public Shark copy() {
            return new Shark(x, y, dir, amount);
        }
    }

    static class Fish implements Comparable<Fish> {
        int num;
        int dir;
        int x;
        int y;

        public Fish(int num, int dir, int x, int y) {
            this.num = num;
            this.dir = dir;
            this.x = x;
            this.y = y;
        }

        public void move(Fish[][] map, Shark shark) {
            for (int i = 0; i < 8; i++) {
                int nextDir = (dir + i) % 8;
                int fx = x + DX[nextDir];
                int fy = y + DY[nextDir];
                if (valid(shark, fx, fy)) {
                    dir = nextDir;
                    changeLocation(map, fx, fy);
                    return;
                }
            }
        }

        public Fish copy() {
            return new Fish(num, dir, x, y);
        }

        private void changeLocation(Fish[][] map, int fx, int fy) {
            Fish fish = map[fy][fx];
            int tempX = this.x;
            int tempY = this.y;
            this.x = fx;
            this.y = fy;
            map[fy][fx] = this;
            if (fish != null) {
                fish.x = tempX;
                fish.y = tempY;
            }
            map[tempY][tempX] = fish;
        }

        private boolean valid(Shark shark, int x, int y) {
            return x >= 0 && y >= 0 && x < 4 && y < 4 && !(shark.x == x && shark.y == y);
        }

        @Override
        public int compareTo(Fish o) {
            return this.num - o.num;
        }
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
