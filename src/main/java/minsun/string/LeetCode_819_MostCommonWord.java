package string;

import java.util.*;

class LeetCode_819_MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> freq = new HashMap<>();

		int idx = 0;
		while (idx < paragraph.length()){
			if (!isAlphabet(paragraph.charAt(idx))){
				idx++;
				continue;
			}

			String cur = "";
			while (idx < paragraph.length() && isAlphabet(paragraph.charAt(idx))) {
				cur += paragraph.charAt(idx++);
			}
			cur = cur.toLowerCase();
			boolean isBanned = false;
			for (String b:banned){
				if (cur.equals(b)) {
					isBanned = true;
					break;
				}
			}
			if (isBanned) continue;

			int value = freq.getOrDefault(cur, 0);
			freq.put(cur, value + 1);
		}

		String answer = "";
		int val = 0;
		for (String key:freq.keySet()){
			if (freq.get(key) > val) {
				answer = key;
				val = freq.get(key);
			}
		}
		return answer;
	}

	private static boolean isAlphabet(char ch){
		return ch >=65 && ch < 91 || ch >= 97 && ch < 123;
	}
}