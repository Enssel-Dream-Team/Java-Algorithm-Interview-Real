package string;

import java.util.*;

class LeetCode_49_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        List<List<String>> answer = new ArrayList<>();

        for (int i=0;i<strs.length;i++){
            if (visited[i]) continue;
            String curWord = strs[i];
            List<String> curList = new ArrayList<>();
            curList.add(curWord);
            int[] curAscii = getAscii(curWord);

            for (int j=i + 1;j<strs.length;j++){
                if (visited[j]) continue;

                String nextWord = strs[j];

                if (curWord.length() != nextWord.length()) continue;

                int[] nextAscii = getAscii(nextWord);

                if (isAnagram(curAscii, nextAscii)) {
                    visited[j] = true;
                    curList.add(nextWord);
                }
            }
            answer.add(curList);
        }
        return answer;
    }

    private static int[] getAscii(String word){
        int[] ascii = new int[26];
        for (int i=0;i<word.length();i++){
            ascii[word.charAt(i) - 97]++;
        }
        return ascii;
    }

    private static boolean isAnagram(int[] curAscii, int[] nextAscii){
        for (int i=0;i<26;i++){
            if (curAscii[i] != nextAscii[i]) return false;
        }
        return true;
    }
}