package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P17143 {

    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Map<Integer, Shark>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Map<Integer, Shark> temp = map.getOrDefault(c, new HashMap<>());
            temp.put(r, new Shark(r, c, s, d, z));
            map.put(c, temp);
        }

        int result = 0;
        for (int i = 0; i < C; i++) {
            result += fishingShark(map, i);
            map = moveSharks(map);
        }
        System.out.println(result);
    }

    private static Map<Integer, Map<Integer, Shark>> moveSharks(Map<Integer, Map<Integer, Shark>> map) {
        Map<Integer, Map<Integer, Shark>> nextMap = new HashMap<>();
        for (Map<Integer, Shark> sharks : map.values()) {
            for (Shark shark : sharks.values()) {
                shark.move();
                Map<Integer, Shark> temp = nextMap.getOrDefault(shark.c, new HashMap<>());
                if (temp.containsKey(shark.r)) {
                    Shark compShark = temp.get(shark.r);
                    if (compShark.z > shark.z) {
                        continue;
                    }
                }
                temp.put(shark.r, shark);
                nextMap.put(shark.c, temp);
            }
        }
        return nextMap;
    }

    private static int fishingShark(Map<Integer, Map<Integer, Shark>> map, int i) {
        int result = 0;
        if (map.containsKey(i)) {
            Map<Integer, Shark> temp = map.get(i);
            int min = Integer.MAX_VALUE;
            for (int key : temp.keySet()) {
                min = Math.min(min, key);
            }
            Shark shark = temp.get(min);
            result = shark.z;
            temp.remove(min);
        }
        return result;
    }

    static class Shark {
        int r;  // row
        int c;  // col
        int s;  // 속력
        boolean isHorizontal;
        int idx;
        int maxIdx;
        int z;  // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.z = z;

            if (d < 3) {
                this.isHorizontal = false;
                this.idx = this.r;
                this.maxIdx = (R - 1) * 2;
                if (d == 1) {
                    this.idx = this.maxIdx - this.r;
                }
            } else {
                this.isHorizontal = true;
                this.idx = this.c;
                this.maxIdx = (C - 1) * 2;
                if (d == 4) {
                    this.idx = this.maxIdx - this.c;
                }
            }
        }

        public void move() {
            this.idx = (this.idx + this.s) % this.maxIdx;
            if (isHorizontal) {
                if (this.idx >= C) {
                    this.c = this.maxIdx - this.idx;
                } else {
                    this.c = this.idx;
                }
            } else {
                if (this.idx >= R) {
                    this.r = this.maxIdx - this.idx;
                } else  {
                    this.r = this.idx;
                }
            }
        }
    }
}
