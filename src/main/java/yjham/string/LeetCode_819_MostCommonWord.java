package yjham.string;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LeetCode_819_MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedSet = Set.of(banned);

		return Pattern.compile("\\W+")
			.splitAsStream(paragraph.toLowerCase())
			.filter(word -> !bannedSet.contains(word))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey)
			.orElse(null);
	}

	// public String mostCommonWord(String paragraph, String[] banned) {
	// 	String[] words = paragraph
	// 		.replaceAll("\\W+", " ")
	// 		.toLowerCase()
	// 		.split(" ");
	//
	// 	Map<String, Long> cntMap = Arrays.stream(words)
	// 		.collect(Collectors.groupingBy(
	// 			Function.identity(),
	// 			Collectors.counting()
	// 		));
	//
	// 	Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
	//
	// 	long max = 0;
	// 	String result = null;
	//
	// 	for (String word : cntMap.keySet()) {
	// 		int before = bannedSet.size();
	// 		bannedSet.add(word);
	// 		int after = bannedSet.size();
	//
	// 		if (after > before) {
	// 			long cnt = cntMap.get(word);
	// 			if (cnt > max) {
	// 				max = cnt;
	// 				result = word;
	// 			}
	// 		}
	// 	}
	//
	// 	return result;
	// }
}
