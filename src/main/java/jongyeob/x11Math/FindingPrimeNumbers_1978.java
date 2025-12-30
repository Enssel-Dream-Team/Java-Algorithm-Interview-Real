package jongyeob.x11Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingPrimeNumbers_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        boolean[] isNotPrime = sieveOfEratosthenes(1000);
        int count = 0;
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            if (!isNotPrime[Integer.parseInt(tokenizer.nextToken())])
                count++;
        }
        System.out.println(count);

    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j * i < n + 1; j++) {
                isNotPrime[i * j] = true;
            }
        }
        return isNotPrime;
    }
}
