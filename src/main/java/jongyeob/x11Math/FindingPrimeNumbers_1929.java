package jongyeob.x11Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingPrimeNumbers_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        boolean[] isNotPrime = sieveOfEratosthenes(m);
        StringBuilder builder = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (!isNotPrime[i]) {
                builder.append(i).append('\n');
            }
        }
        System.out.println(builder);
    }

    private static boolean[] sieveOfEratosthenes(int m) {
        boolean[] isNotPrime = new boolean[m + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j * i < m + 1; j++) {
                isNotPrime[i * j] = true;
            }
        }
        return isNotPrime;
    }
}
