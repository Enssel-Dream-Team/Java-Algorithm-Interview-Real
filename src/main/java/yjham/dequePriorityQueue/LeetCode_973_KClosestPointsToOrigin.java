package yjham.dequePriorityQueue;

import java.util.PriorityQueue;

public class LeetCode_973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        for (int[] point : points) pq.offer(new Point(point[0], point[1]));

        for (int i = 0; i < k; i++) result[i] = pq.poll().point;

        return result;
    }

    class Point {
        int[] point;
        int dist;

        public Point(int x, int y) {
            this.point = new int[]{x, y};
            this.dist = x * x + y * y;
        }
    }
}
