package seonguk.deque;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode_347_TopKFrequentElements {
	static class Number implements Comparable<Number> {
		private int num, cnt;

		public Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Number o) {
			return o.cnt - this.cnt;
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[k];
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Number> pq = new PriorityQueue<>();
		for(int key : map.keySet()) {
			pq.add(new Number(key, map.get(key)));
		}
		for(int i = 0; i < k; i++) {
			ans[i] = pq.poll().num;
		}

		return ans;
	}
}
