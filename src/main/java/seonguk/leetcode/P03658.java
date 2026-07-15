package seonguk.leetcode;

public class P03658 {
    class Solution {
        public int gcdOfOddEvenSums(int n) {
            int sumOdd = n * n;
            int sumEven = n * (n + 1);

            return gcd(sumEven, sumOdd);
        }

        static int gcd(int num1, int num2) {
            if (num1 % num2 == 0) {
                return num2;
            }

            return gcd(num2, num1 % num2);
        }
    }
}
