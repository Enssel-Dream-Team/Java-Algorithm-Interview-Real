package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class FashionKingShinHaebin_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        for (int testCase = 0; testCase < t; testCase++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                String value = tokenizer.nextToken();
                String key = tokenizer.nextToken();
                if (hashMap.get(key) == null) {
                    hashMap.put(key, 1);
                } else {
                    Integer pre = hashMap.get(key);
                    hashMap.put(key, pre + 1);
                }
            }
            int result = 1;
            Set<String> keys = hashMap.keySet();
            for (String key : keys) {
                result *= (hashMap.get(key) + 1);
            }
            result -= 1;
            System.out.println(result);
        }

    }
}
