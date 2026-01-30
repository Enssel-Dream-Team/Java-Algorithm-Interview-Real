package jongyeob.x13BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Multiverse2_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        Map<String, Integer> balanceResult = compactPosition(m, reader, n);
        int count = 0;
        for (String key : balanceResult.keySet()) {
            Integer value = balanceResult.get(key);
            count += (value * (value - 1)) / 2;
        }
        System.out.println(count);
    }

    private static Map<String, Integer> compactPosition(int m, BufferedReader reader, int n) throws
        IOException {
        Map<String, Integer> balance = new HashMap<>();
        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                input[j] = value;
            }
            int[] sortedSet = input.clone();
            Arrays.sort(sortedSet);
            Map<Integer, Integer> rank = new HashMap<>();
            int index = 0;
            rank.put(sortedSet[0], index);
            for (int j = 1; j < sortedSet.length; j++) {
                if (sortedSet[j] != sortedSet[j - 1]) {
                    index++;
                    rank.put(sortedSet[j], index);
                }
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int value = rank.get(input[j]);
                keyBuilder.append(value).append(",");
            }
            String buildKey = keyBuilder.toString();
            balance.put(buildKey, balance.getOrDefault(buildKey, 0) + 1);
        }
        return balance;
    }
}
