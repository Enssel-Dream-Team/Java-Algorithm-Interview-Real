package seonguk.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P31575 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        map[0][0] = 0;

        boolean flag = false;
        while(!que.isEmpty()) {
            Point p = que.poll();
            if (p.x == N - 1 && p.y == M - 1) {
                flag = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int fx = p.x + dx[i];
                int fy = p.y + dy[i];
                if (fx >= 0 && fx < N && fy >= 0 && fy < M && map[fy][fx] == 1) {
                    map[fy][fx] = 0;
                    que.add(new Point(fx, fy));
                }
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
