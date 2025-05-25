package hyeongil.stackqueue;

import java.util.PriorityQueue;

public class LeetCode_973_KClosestPointsToOrigin {

    static class Point implements Comparable<Point> {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        // 원점에 가까운 점이 우선 순위가 높다.
        @Override
        public int compareTo(Point o) {
            double distanceToOrigin = Math.sqrt(Math.pow(y, y) + Math.pow(x, x));
            double otherDistanceToOrigin = Math.sqrt(Math.pow(o.y, o.y) + Math.pow(o.x, o.x));
            if (distanceToOrigin == otherDistanceToOrigin) return 0;
            return distanceToOrigin < otherDistanceToOrigin ? - 1 : 1;
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        // 1. 원점에 가장 가까운 k개의 점을 찾는 문제.
        // -> 가장 우선순위가 높은 점을 조회하면 되는 문제.
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int[] point : points) {
            pq.offer(new Point(point[1], point[0]));
        }

        return pq.stream()
                .limit(k)
                .map(point -> {
                    return new int[]{point.x, point.y};
                })
                .toArray(int[][]::new);

    }
}
