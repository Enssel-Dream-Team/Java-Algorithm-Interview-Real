package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01347 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        List<Point> points = new ArrayList<>();
        Point p = new Point(0, 0);
        points.add(p);

        int dir = 0;
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;
        for (char c : arr) {
            switch (c) {
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                case 'L':
                    dir = (dir + 3) % 4;
                    break;
                default:
                    Point temp = new Point(p.x + dx[dir], p.y + dy[dir]);
                    points.add(temp);
                    p = temp;
                    minX = Math.min(minX, temp.x);
                    minY = Math.min(minY, temp.y);
                    maxX = Math.max(maxX, temp.x);
                    maxY = Math.max(maxY, temp.y);
            }
        }
        char[][] map = new char[maxY - minY + 1][maxX - minX + 1];
        for (char[] row : map) {
            Arrays.fill(row, '#');
        }

        for (Point point : points) {
            map[point.y - minY][point.x - minX] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
