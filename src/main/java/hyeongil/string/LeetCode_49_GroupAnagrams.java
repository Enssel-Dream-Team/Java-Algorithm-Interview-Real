package hyeongil.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An anagram is a word or phrase formed by rearranging
 * the letters of a different word or phrase,
 * using all the original letters exactly once.
 *
 * 애너그램
 * - 다른 단어의 문자들을 재정렬해서 만들 수 있는 단어를 애너그램이라고 한다.
 * - nat, tan 같은 경우 알파벳을 정렬하면 ant라는 같은 애너그램이 형성된다.
 *
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class LeetCode_49_GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 문자열의 알파벳을 정렬한 새로운 문자열을 key값으로 애너그램을 묶는다.
        Map<String, List<String>> anagrams = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        s -> {
                            char[] array = s.toCharArray();
                            Arrays.sort(array);
                            return new String(array);
                        },
                        Collectors.toList()
                ));

        return new ArrayList<>(anagrams.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
}
