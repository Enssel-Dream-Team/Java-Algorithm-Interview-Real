package seonguk.leetcode;

public class P00877 {
    class Solution {
        static int[] piles;
        static int leftIdx, rightIdx;

        public boolean stoneGame(int[] piles) {
            int alice = 0;
            int bob = 0;

            this.piles = piles;
            leftIdx = 0;
            rightIdx = piles.length - 1;

            boolean isAliceTurn = true;

            while (leftIdx <= rightIdx) {
                if (isAliceTurn) {
                    alice += calcScore();
                } else {
                    bob += calcScore();
                }
            }

            return alice > bob;
        }

        static int calcScore() {
            if (pickLeft()) {
                return piles[leftIdx++];
            }
            return piles[rightIdx--];
        }

        static boolean pickLeft() {
            if (leftIdx == rightIdx) {
                return true;
            }
            int lScore = piles[leftIdx] - Math.max(piles[leftIdx + 1], piles[rightIdx]);
            int rScore = piles[rightIdx] - Math.max(piles[leftIdx], piles[rightIdx - 1]);

            return lScore > rScore;
        }
    }
}
