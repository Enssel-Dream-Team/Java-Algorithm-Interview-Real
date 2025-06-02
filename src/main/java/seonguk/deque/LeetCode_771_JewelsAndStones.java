package seonguk.deque;

public class LeetCode_771_JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {
		int len = stones.length();
		for(char c : jewels.toCharArray()) {
			stones = stones.replace(c + "", "");
		}

		return len - stones.length();
	}
}
