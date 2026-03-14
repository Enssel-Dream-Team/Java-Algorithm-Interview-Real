package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20056 {
    static int N;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Fireball> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball fireball = new Fireball(r, c, m, s, d);
            map.put(fireball.getIndex(), fireball);
        }

        for (int i = 0; i < K; i++) {
            calcNext(map);
        }
    }

    private static void calcNext(Map<Integer, Fireball> map) {
        Map<Integer, Fireball> nextMap = new HashMap<>();
        Map<Integer, Fireball> addedFireballMap;

        do {
            addedFireballMap = new HashMap<>();
            for (Fireball fireball : map.values()) {
                fireball.move();
                if (!nextMap.containsKey(fireball.getIndex())) {
                    nextMap.put(fireball.getIndex(), fireball);
                } else {
                    Fireball nextFireball = nextMap.get(fireball.getIndex());
                    nextFireball.addFireball(fireball);
                    nextMap.put(fireball.getIndex(), nextFireball);
                    addedFireballMap.put(fireball.getIndex(), nextFireball);
                }
            }


            map = nextMap;
        } while (!addedFireballMap.isEmpty());
    }

    static class Fireball {
        int r, c, m, s, d;
        int cnt;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s % N;
            this.d = d;
            this.cnt = 1;
        }

        public void move() {
            this.r = (N + this.r + (dy[this.d] * this.s)) % N;
            this.c = (N + this.c + (dx[this.d] * this.s)) % N;
        }

        public void addFireball(Fireball f) {
            this.cnt++;
            this.m += f.m;
            this.s += f.s;
        }

        public int getIndex() {
            return c * N + r;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Fireball fireball = (Fireball) o;
            return r == fireball.r && c == fireball.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
