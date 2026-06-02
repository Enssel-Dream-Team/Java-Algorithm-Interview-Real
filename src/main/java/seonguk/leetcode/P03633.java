package seonguk.leetcode;

import java.util.*;

public class P03633 {
    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            int landMin = Integer.MAX_VALUE;
            int waterMin = Integer.MAX_VALUE;

            int landLength = landStartTime.length;
            int waterLength = waterStartTime.length;

            for (int i = 0; i < landLength; i++) {
                landMin = Math.min(landMin, landStartTime[i] + landDuration[i]);
            }

            for (int i = 0; i < waterLength; i++) {
                waterMin = Math.min(waterMin, waterStartTime[i] + waterDuration[i]);
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < waterLength; i++) {
                int sTime = waterStartTime[i];
                int duration = waterDuration[i];
                if (sTime <= landMin) {
                    ans = Math.min(ans, landMin + duration);
                } else {
                    ans = Math.min(ans, sTime + duration);
                }
            }

            for (int i = 0; i < landLength; i++) {
                int sTime = landStartTime[i];
                int duration = landDuration[i];
                if (sTime <= waterMin) {
                    ans = Math.min(ans, waterMin + duration);
                } else {
                    ans = Math.min(ans, sTime + duration);
                }
            }

            return ans;
        }
    }
}
