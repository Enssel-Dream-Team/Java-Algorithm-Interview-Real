package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CourseRegistration_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            hashMap.put(reader.readLine(), i);
        }
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        String[] sortedKeys = new String[l];
        for (Map.Entry<String, Integer> entry : entries) {
            sortedKeys[entry.getValue()] = entry.getKey();
        }
        for (int i = 0; i < l; i++) {
            if (sortedKeys[i] == null)
                continue;
            System.out.println(sortedKeys[i]);
            k--;
            if (k == 0)
                break;
        }
        System.out.println();
    }
}
