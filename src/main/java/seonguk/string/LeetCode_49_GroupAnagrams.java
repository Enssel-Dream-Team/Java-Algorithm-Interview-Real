package seonguk.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class LeetCode_49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] temp = new int[26];
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                temp[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                char c = (char)('a' + i);
                sb.append(c + temp[i]);
            }
            String key = sb.toString();
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> val = new ArrayList<>();
                val.add(str);
                map.put(key, val);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet())
            ans.add(map.get(key));

        return ans;
    }
}
