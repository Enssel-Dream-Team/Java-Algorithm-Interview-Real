package seonguk.leetcode;

import java.util.*;

public class P01288 {

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            int n = intervals.length;
            Interval[] arr = new Interval[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Interval(intervals[i]);
            }

            Arrays.sort(arr);

            List<Interval> list = new ArrayList<>();
            list.add(arr[0]);

            for (int i = 1; i < n; i++) {
                Interval interval = arr[i];
                boolean flag = true;
                for (Interval in : list) {
                    if (in.isCovered(interval)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    list.add(interval);
                }
            }

            return list.size();
        }

        static class Interval implements Comparable<Interval> {
            int min;
            int max;

            Interval(int[] arr) {
                min = arr[0];
                max = arr[1];
            }

            boolean isCovered(Interval o) {
                if (min <= o.min && o.max <= max) {
                    return true;
                }

                return false;
            }

            @Override
            public int compareTo(Interval o) {
                if (this.min == o.min) {
                    return o.max - this.max;
                }
                return this.min - o.min;
            }
        }
    }
}
