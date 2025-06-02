package minsun.hashtable;

import java.util.*;

class 프로그래머스_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> freq = new HashMap<>();
        Arrays.stream(participant).forEach(x -> freq.put(x, freq.getOrDefault(x, 0) + 1));
        Arrays.stream(completion).forEach(x -> freq.put(x, freq.getOrDefault(x, 0) - 1));
        String answer
                = freq
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .map(Map.Entry::getKey)
                .findAny()
                .orElse("");

        return answer;
    }
}