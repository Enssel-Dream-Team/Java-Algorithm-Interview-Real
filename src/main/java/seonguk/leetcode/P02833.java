package seonguk.leetcode;

public class P02833 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String moves = "L_RL__R";
        System.out.println(s.furthestDistanceFromOrigin(moves));
    }

    static class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int rCnt = 0;
            int lCnt = 0;
            int uCnt = 0;

            for (char c : moves.toCharArray()) {
                switch(c) {
                    case 'R':
                        rCnt++;
                        break;
                    case 'L':
                        lCnt++;
                        break;
                    default:
                        uCnt++;
                }
            }

            return Math.abs(rCnt - lCnt) + uCnt;
        }
    }
}
