package seonguk.leetcode;

public class P01344 {
    class Solution {
        static final int HOUR_ANGLE = 30;
        static final int MINUTE_ANGLE = 6;

        public double angleClock(int hour, int minutes) {
            double h = (hour + (double)minutes / 60) * HOUR_ANGLE;
            double m = minutes * MINUTE_ANGLE;

            if (h - m > 180) {
                return 360 - (h - m);
            } else if (h - m < 0) {
                if (m - h > 180) {
                    return 360 - (m - h);
                } else {
                    return m - h;
                }
            } else {
                return h - m;
            }
        }
    }
}
