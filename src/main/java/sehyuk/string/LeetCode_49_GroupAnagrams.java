package sehyuk.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 49. Group Anagrams
 * Link : https://leetcode.com/problems/group-anagrams
 * explanation :
 * 1. 반환을 위한 List와 목록을 저장할 Map을 만든다.
 * 2. strs 배열을 순회하면서 toCharArray()로 변환하여 순서대로 세팅한다.
 * 3. 세팅된 문자열을 키로 하여 Map에 저장한다.
 * 4. Map의 모든 요소를 순회하면서 기존 문자열을 정렬하고 값을 반환한다.
 */
public class LeetCode_49_GroupAnagrams{
	// 입력 : "eat tea tan ate nat bat"
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] strs = new String[st.countTokens()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = st.nextToken();
		}
		groupAnagrams(strs);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> hashMap = new HashMap<>();
		for(int i=0; i<strs.length;i++){
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String word = new String(charArray);
			List<String> list = hashMap.getOrDefault(word, new ArrayList<>());
			list.add(strs[i]);
			hashMap.put(word,list);
		}
		for(Map.Entry<String, List<String>> entry : hashMap.entrySet()){
			List<String> list = entry.getValue();
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
}
