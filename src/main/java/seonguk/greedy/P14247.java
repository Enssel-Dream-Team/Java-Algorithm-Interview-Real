package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        Tree[] trees = new Tree[N];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st1.nextToken());
            int growth = Integer.parseInt(st2.nextToken());
            trees[i] = new Tree(height, growth);
        }

        Arrays.sort(trees);
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += trees[i].cut(i);
        }
        System.out.println(ans);
    }

    static class Tree implements Comparable<Tree> {
        int height;
        int growth;

        public Tree(int height, int growth) {
            this.height = height;
            this.growth = growth;
        }

        public long cut(int days) {
            return (long)this.growth * days + this.height;
        }

        @Override
        public int compareTo(Tree o) {
            return this.growth - o.growth;
        }
    }
}
