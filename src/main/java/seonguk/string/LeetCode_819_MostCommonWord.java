package seonguk.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_819_MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ");
        while(paragraph.contains("  "))
            paragraph = paragraph.replaceAll("  ", " ");

        String[] arr = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for(String str : arr) {
            if(map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }

        for(String str : banned)
            if(map.containsKey(str))
                 map.remove(str);

        String ans = "";
        int cnt = 0;

        for(String key : map.keySet()) {
            int temp = map.get(key);
            if (cnt < map.get(key)) {
                cnt = temp;
                ans = key;
            }
        }

        return ans;
    }
}
