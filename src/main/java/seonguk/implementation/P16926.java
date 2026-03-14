package seonguk.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class P16926 {

    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = (Math.min(N, M)) / 2;
        for (int i = 0; i < min; i++) {
            rotate(map, i,N - i * 2, M - i * 2);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void rotate(int[][] map, int startIdx, int row, int col) {
        int oneCycle = (row + col - 2) * 2;
        Point[] points = setPoints(startIdx, startIdx, row, col, oneCycle);
        calcRotation(map, points, R % oneCycle, oneCycle);
    }

    private static void calcRotation(int[][] map, Point[] points, int r, int oneCycle) {
        while (r-- > 0) {
            Point nextPoint = points[0];
            int nextVal = map[nextPoint.row][nextPoint.col];
            for (int i = 0; i < points.length; i++) {
                nextPoint = points[(i + 1) % oneCycle];
                int temp = map[nextPoint.row][nextPoint.col];
                map[nextPoint.row][nextPoint.col] = nextVal;
                nextVal = temp;
            }
        }
    }

    private static Point[] setPoints(int startRow, int startCol, int row, int col, int oneCycle) {
        Point[] result = new Point[oneCycle];
        result[0] = new Point(startRow, startCol);

        int idx = 0;
        for (int i = 1; i < row; i++) {
            result[++idx] = new Point(++startRow, startCol);
        }
        for (int i = 1; i < col; i++) {
            result[++idx] = new Point(startRow, ++startCol);
        }
        for (int i = 1; i < row; i++) {
            result[++idx] = new Point(--startRow, startCol);
        }
        for (int i = 1; i < col - 1; i++) {
            result[++idx] = new Point(startRow, --startCol);
        }
        return result;
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
