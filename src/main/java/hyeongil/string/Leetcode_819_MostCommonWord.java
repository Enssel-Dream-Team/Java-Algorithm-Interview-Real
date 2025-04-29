package hyeongil.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * Given a string paragraph and a string array of the banned words banned,
 *
 * return the most frequent word that is not banned.
 * It is guaranteed there is at least one word that is not banned,
 * and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and
 * the answer should be returned in lowercase.
 *
 */
public class Leetcode_819_MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> banList = Arrays.asList(banned);
        String lowerCaseParagraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String[] words = lowerCaseParagraph
                .replaceAll("[!?',;.]", " ")
                .split(" ");

        for (String word : words) {
            // 문자가 공백이라면, 그냥 넘어간다.
            String trimmed = word.trim();
            if (word.isBlank()) {
                continue;
            }

            if (banList.contains(trimmed)) {
                continue;
            }

            map.put(trimmed, map.getOrDefault(trimmed, 0) + 1);

        }

        return map.entrySet()
                .stream()
                .max(Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static void main(String[] args) {
        String[] banList = {"hit"};
        String commandWord = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banList);
        System.out.println("commandWord = " + commandWord);
    }
}
