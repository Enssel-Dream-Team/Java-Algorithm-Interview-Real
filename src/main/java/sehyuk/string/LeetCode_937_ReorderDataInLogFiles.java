package sehyuk.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 937. Reorder Data in Log Files
 * Link : https://leetcode.com/problems/reorder-data-in-log-files
 * explanation :
 * // condition 1 : 모든 숫자 로그는 문자 로그 뒤에 있다.
 * // condition 2 : 문자 로그는 사전 순으로 배치한다. 만약 로그가 같다면 인식값으로 사전순으로 정렬
 * // condition 3 : 숫자 로그의 순서는 유지힌다.
 * 1. 조건에 맞추어 Comparable 인터페이스를 구현한 Log 클래스를 만든다.
 * 2. List<Log> 클래스를 만들고 log에 맞게 추가하고 정렬한다.
 * 3. 정렬된 결과를 배열로 변환하여 반환한다.
 */

public class LeetCode_937_ReorderDataInLogFiles {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 ar zero"};
		reorderLogFiles(input);
	}

	static class Log implements Comparable<Log> {
		public String logWord;
		public String identifierWord;
		public boolean isDigit;

		public Log(String identifierWord, String logWord) {
			this.identifierWord = identifierWord;
			this.logWord = logWord;
			this.isDigit = Character.isDigit(logWord.charAt(0)) ? true : false;
		}

		@Override
		public int compareTo(Log other) {
			// 문자 로그 차이라면?
			if (!this.isDigit && !other.isDigit) {
				int compareValue = this.logWord.compareTo(other.logWord);
				if (compareValue != 0) {
					return compareValue;
				}
				return this.identifierWord.compareTo(other.identifierWord);
			}

			// 서로 다른 로그라면
			if (!this.isDigit && other.isDigit) {
				return -1;
			}

			if (this.isDigit && !other.isDigit) {
				return 1;
			}

			// 둘 다 숫자 로그면
			return 0;
		}
	}

	public static String[] reorderLogFiles(String[] logs) {
		List<Log> list = new ArrayList<>();
		for (int i = 0; i < logs.length; i++) {
			String[] log = logs[i].split(" ");
			list.add(new Log(log[0], logs[i].substring(log[0].length() + 1)));

		}
		Collections.sort(list);
		String[] listCopy = list.stream()
			.map(log -> log.identifierWord + " " + log.logWord)
			.toArray(String[]::new);
		return listCopy;

	}

}
