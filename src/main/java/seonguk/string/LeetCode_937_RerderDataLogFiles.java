package seonguk.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_937_RerderDataLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(int i = 0; i < logs.length; i++) {
            String[] temp = logs[i].split(" ");
            char c = temp[1].charAt(0);
            if(Character.isDigit(c)) {
                digitList.add(logs[i]);
            } else {
                letterList.add(new Log(logs[i]));
            }
        }

        String[] ans = new String[logs.length];
        int idx = 0;

        Collections.sort(letterList);

        for(Log log : letterList)
            ans[idx++] = log.original;
        for(String str : digitList)
            ans[idx++] = str;

        return ans;
    }

    static class Log implements Comparable<Log> {
        String original;
        String identifier;
        String words;

        public Log(String log) {
            original = log;
            int idx = log.indexOf(' ');
            identifier = log.substring(0, idx);
            words = log.substring(idx);
        }

        @Override
        public int compareTo(Log o) {
            int result = this.words.compareTo(o.words);
            if(result == 0)
                return this.identifier.compareTo(o.identifier);
            return result;
        }
    }
}
