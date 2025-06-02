package minsun.hashtable;

import java.util.*;

public class LeetCode_347_TopKFrequentElements {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] answer = map
                .keySet()
                .stream()
                .sorted(
                        Comparator
                                .comparing(map::get)
                                .reversed()
                )
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
