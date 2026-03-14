package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16235 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기
        int M = Integer.parseInt(st.nextToken());   // 나무의 수
        int K = Integer.parseInt(st.nextToken());   // K년 후

        int[][] map = new int[N][N];
        int[][] addNutritionMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = 5;
                addNutritionMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            pq.add(new Tree(x, y, z));
        }

        for (int i = 0; i < K; i++) {
            // 봄
            ArrayList<Tree> deadTreeList = new ArrayList<>();
            ArrayList<Tree> grownTreeList = new ArrayList<>();
            while (!pq.isEmpty()) {
                Tree tree = pq.poll();
                tree.grow(map);
                if (tree.isDead) {
                    deadTreeList.add(tree);
                } else {
                    grownTreeList.add(tree);
                }
            }

            // 여름
            for (Tree tree : deadTreeList) {
                addNutritionMap[tree.r][tree.c] += tree.beNutrition();
            }

            // 가을
            for (Tree tree : grownTreeList) {
                pq.add(tree);
                List<Tree> childList = tree.breed();
                if (childList != null) {
                    pq.addAll(childList);
                }
            }

            // 겨울
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] += addNutritionMap[j][k];
                }
            }
        }

        System.out.println(pq.size());
        br.close();
    }

    static class Tree implements Comparable<Tree> {
        static final int[] DX = {1, 1, 1, 0, -1, -1, -1, 0};
        static final int[] DY = {1, 0, -1, -1, -1, 0, 1, 1};
        int r, c;
        int age;
        boolean isDead;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
            isDead = false;
        }

        // 봄에 양분을 먹고 자람
        public void grow(int[][] map) {
            // 양분이 충분하지 않은 경우 죽음으로 반환
            if (map[r][c] < age) {
                isDead = true;
                return;
            }

            map[r][c] -= age;
            age++;
        }

        // 여름에 양분이 됨
        public int beNutrition() {
            return age / 2;
        }

        // 가을에 번식
        public List<Tree> breed() {
            if (age % 5 != 0) {
                return null;
            }

            List<Tree> trees = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                int fx = c + DX[i];
                int fy = r + DY[i];
                if (fx >= 0 && fx < N && fy >= 0 && fy < N) {
                    trees.add(new Tree(fx, fy, 1));
                }
            }
            return trees;
        }

        @Override
        public int compareTo(Tree o) {
            return age - o.age;
        }
    }
}
