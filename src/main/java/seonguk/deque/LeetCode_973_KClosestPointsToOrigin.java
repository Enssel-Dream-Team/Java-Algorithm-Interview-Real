package seonguk.deque;

import java.util.*;

public class LeetCode_973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int[] point : points) {
            pq.add(new Point(point[0], point[1]));
        }

        for(int i = 0; i < k; i++) {
            Point point = pq.poll();
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }

        return ans;
    }

    static class Point implements Comparable<Point> {
        int x, y, dist;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = x * x + y * y;
        }

        @Override
        public int compareTo(Point o) {
            return dist - o.dist;
        }
    }
}
