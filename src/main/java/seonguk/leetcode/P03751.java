package seonguk.leetcode;

import java.util.*;

public class P03751 {

    class Solution {
        public int totalWaviness(int num1, int num2) {
            if (num2 < 100) {
                return 0;
            }

            if (num1 < 100) {
                num1 = 100;
            }

            int ans = 0;
            for (int i = num1; i <= num2; i++) {
                List<Integer> list = new ArrayList<>();
                int temp = i;
                while (temp > 0) {
                    list.add(temp % 10);
                    temp /= 10;
                }
                for (int j = 1; j < list.size() - 1; j++) {
                    if (checkWave(list, j)) {
                        ans++;
                    }
                }
            }

            return ans;
        }

        private boolean checkWave(List<Integer> list, int idx) {
            int left = list.get(idx - 1);
            int mid = list.get(idx);
            int right = list.get(idx + 1);
            if (mid > left && mid > right) {
                return true;
            }
            if (mid < left && mid < right) {
                return true;
            }

            return false;
        }
    }
}
