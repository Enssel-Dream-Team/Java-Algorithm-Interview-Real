package seonguk.leetcode;

import java.util.*;

public class P02657 {
    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            int[] C = new int[n];

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (A[i] == B[i]) {
                    C[i] = ++cnt;
                    continue;
                }
                if (setA.contains(B[i])) {
                    setA.remove(B[i]);
                    cnt++;
                } else {
                    setB.add(B[i]);
                }
                if (setB.contains(A[i])) {
                    setB.remove(A[i]);
                    cnt++;
                } else {
                    setA.add(A[i]);
                }
                C[i] = cnt;
            }

            return C;
        }
    }
}
