package hyeongil.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * nums 중 두 개의 원소를 더해서 target이 될 경우의 두 수의 인덱스 배열을 리턴해라.
 */
public class Leetcode_1_TwoSum {

    // target - num인 수가 존재한다면 i번째 원소를 포함 시키고, target - num인 수의 인덱스를 구하면 된다.
    public int[] twoSum(int[] nums, int target) {
        // 1. num : index인 map을 생성한다.
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            numToIndex.put(num ,i);
        }

        // 2. target - num를 한 수가 존재한다면 map에 존재한다면 두 개의 쌍이 정답이다.
        // 단, 동일한 인덱스이면 안된다.
        for (int i = 0; i < length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                int otherIndex = numToIndex.get(target - nums[i]);
                if (otherIndex != i)
                    return new int[]{i, otherIndex};
            }
        }
        return null;
    }
}
