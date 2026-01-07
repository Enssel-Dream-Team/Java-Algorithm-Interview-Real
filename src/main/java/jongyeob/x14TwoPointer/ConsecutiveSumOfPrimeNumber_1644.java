package jongyeob.x14TwoPointer;

import java.util.Scanner;

public class ConsecutiveSumOfPrimeNumber_1644 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sumOfPrimeNumberCount = twoPoint(n);
        System.out.println(sumOfPrimeNumberCount);
    }

    private static int twoPoint(int n) {
        if (n == 1) {
            return 0;
        }
        boolean[] isNotSieve = sieveOfEratosthenes(n);
        int start = 2;
        int currentSum = 0;
        int equalSumCount = 0;
        for (int end = 2; end < n + 1; end++) {
            if (isNotSieve[end])
                continue;
            currentSum += end;
            while (currentSum > n && start < end) {
                if (!isNotSieve[start]) {
                    currentSum -= start;
                }
                start++;
            }
            if (currentSum == n)
                equalSumCount++;
        }
        return equalSumCount;
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isNotSieve = new boolean[n + 1];
        isNotSieve[0] = true;
        isNotSieve[1] = true;
        for (int i = 2; i * i < n + 1; i++) {
            if (isNotSieve[i])
                continue;
            for (int j = i * i; j < n + 1; j += i) {
                isNotSieve[j] = true;
            }
        }
        return isNotSieve;
    }
}
