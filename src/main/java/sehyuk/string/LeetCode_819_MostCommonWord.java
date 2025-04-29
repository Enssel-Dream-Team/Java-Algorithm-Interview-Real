package sehyuk.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 819. Most Common Word
 * Link : https://leetcode.com/problems/most-common-word
 * explanation :
 * 1. 문자열에서 소문자와 대문자를 제외한 문자들을 모두 공백으로 변환하고 공백을 기준으로 분리힌다.
 * 2. 분리된 문자열을 순회하면서 공백은 제외하고 banned 단어가 아니면 해시맵에 단어의 빈도수를 저장한다.
 * 3. 가장 많은 빈도 수를 가진 단어를 반환한다.
 */
public class LeetCode_819_MostCommonWord {
	public static void main(String[] args) {
		String paragraph = "Bob. hIt, baLl";
		String[] banned = {"bob", "hit"};
		String result = mostCommonWord(paragraph, banned);
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		String result="";
		int maxCount = -1;


		Set<String> bannedWordSet = new HashSet<>(Arrays.asList(banned));

		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");



		Map<String, Integer> wordCountMap = new HashMap<>();


		for (String word : words) {
			if (!word.isBlank() && !bannedWordSet.contains(word)) {
				wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
				if (wordCountMap.get(word) > maxCount) {
					maxCount = wordCountMap.get(word);
					result = word;
				}
			}
		}

		return result;
	}
}