package seonguk.stackQueue;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LeetCode_316_RemoveDuplicateLetters {
    public Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });

        for(char c : s.toCharArray())
            set.add(c);

        return set;
    }

    public String removeDuplicateLetters(String s) {
        for(char c : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            if(toSortedSet(s).equals(toSortedSet(suffix)))
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
        }
        return "";
    }
}
