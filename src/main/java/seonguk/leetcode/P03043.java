package seonguk.leetcode;

import java.util.*;

public class P03043 {
    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<String> set = new HashSet<>();
            setInit(set, arr1);

            String result = "";
            for (int i = 0; i < arr2.length; i++) {
                String str = arr2[i] + "";
                for (int j = str.length(); j > result.length(); j--) {
                    String comp = str.substring(0, j);
                    if (set.contains(comp)) {
                        result = comp;
                    }
                }
            }

            return result.length();
        }

        private void setInit(Set<String> set, int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                String str = arr[i] + "";
                for (int j = 0; j < str.length(); j++) {
                    set.add(str.substring(0, j + 1));
                }
            }
        }
    }
}
