package seonguk.leetcode;

import java.util.*;

public class P02452 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};

        System.out.println(s.twoEditWords(queries, dictionary));
    }

    static class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> ans = new ArrayList<>();
            char[][] charQueries = new char[queries.length][1];
            char[][] charDictionary = new char[dictionary.length][1];

            for (int i = 0; i < dictionary.length; i++) {
                charDictionary[i] = dictionary[i].toCharArray();
            }

            for (int i = 0; i < queries.length; i++) {
                if (checkMatch(queries[i].toCharArray(), charDictionary)) {
                    ans.add(queries[i]);
                }
            }

            return ans;
        }

        private boolean checkMatch(char[] target, char[][] dictionary) {
            for (char[] comp : dictionary) {
                if (target.length != comp.length) {
                    continue;
                }

                int cnt = 0;
                boolean flag = true;
                for (int i = 0; i < target.length; i++) {
                    if (target[i] != comp[i]) {
                        if (++cnt > 2) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    return true;
                }
            }

            return false;
        }
    }
}
