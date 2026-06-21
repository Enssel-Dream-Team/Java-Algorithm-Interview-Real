package seonguk.leetcode;

import java.util.*;

public class P01833 {
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);

            int cnt = 0;
            for (int cost : costs) {
                if (coins < cost) {
                    break;
                }
                coins -= cost;
                cnt++;
            }

            return cnt;
        }
    }
}
