package seonguk.bfs;

import java.io.*;
import java.util.*;

public class P16236 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;

                if (val == 9) {
                    shark = new Shark(j, i);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!shark.findFish(map)) {
                break;
            }
        }

        System.out.println(shark.survivedTime);
        br.close();
    }

    static class Shark {
        static final int[] DX = {0, -1, 0, 1};
        static final int[] DY = {-1, 0, 1, 0};

        int x, y;
        int size;
        int eatCnt;
        int survivedTime;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eatCnt = 0;
            this.survivedTime = 0;
        }

        public boolean findFish(int[][] map) {
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<Position> pq = new PriorityQueue<>();
            Deque<Position> que = new LinkedList<>();
            que.addLast(new Position(this.x, this.y, 0));

            while (!que.isEmpty()) {
                Position p = que.pollFirst();
                if (map[p.y][p.x] > 0 && map[p.y][p.x] < size) {
                    pq.add(p);
                }

                for (int i = 0; i < 4; i++) {
                    int fx = p.x + DX[i];
                    int fy = p.y + DY[i];
                    if (fx >= 0 && fx < N && fy >= 0 && fy < N && !visited[fy][fx] && map[fy][fx] <= size) {
                        visited[fy][fx] = true;
                        que.add(new Position(fx, fy, p.dist + 1));
                    }
                }
            }

            if (!pq.isEmpty()) {
                eatFish(map, pq.poll());
                return true;
            }

            return false;
        }

        private void eatFish(int[][] map, Position p) {
            if (++this.eatCnt == this.size) {
                this.eatCnt = 0;
                this.size++;
            }

            this.survivedTime += p.dist;
            map[p.y][p.x] = 0;
            this.x = p.x;
            this.y = p.y;
        }
    }

    static class Position implements Comparable<Position> {
        int x, y;
        int dist;

        public Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }


        @Override
        public int compareTo(Position o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }
}
