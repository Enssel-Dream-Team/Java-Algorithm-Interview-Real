package minsun.stackQueue;

import java.util.Arrays;

class LeetCode_973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int idx = 0;
        Arrays.sort(points, (a, b) -> Double.compare(getDistance(a[0], a[1]), getDistance(b[0], b[1])));
        int[][] answer = new int[k][2];
        for (int i=0;i<k;i++){
            answer[i] = points[i];
        }
        return answer;
    }

    private static double getDistance(int x, int y){
        return Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
    }
}