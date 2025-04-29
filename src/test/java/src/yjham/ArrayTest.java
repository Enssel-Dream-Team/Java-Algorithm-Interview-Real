package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import yjham.array.*;

@DisplayName("6_배열 처리 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ArrayTest {

	@Test
	void Two_Sum() {
		LeetCode_1_TwoSum exam = new LeetCode_1_TwoSum();

		// 1
		assertArrayEquals(new int[] {0, 1}, exam.twoSum(new int[] {2, 7, 11, 15}, 9));

		// 2
		assertArrayEquals(new int[] {1, 2}, exam.twoSum(new int[] {3, 2, 4}, 6));

		// 3
		assertArrayEquals(new int[] {0, 1}, exam.twoSum(new int[] {3, 3}, 6));
	}

	@Test
	void Trapping_Rain_Water() {
		LeetCode_42_TrappingRainWater exam = new LeetCode_42_TrappingRainWater();

		// 1
		assertEquals(6, exam.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

		// 2
		assertEquals(9, exam.trap(new int[] {4, 2, 0, 3, 2, 5}));
	}

	@Test
	void Three_Sum() {
		LeetCode_15_3Sum exam = new LeetCode_15_3Sum();

		// 1
		List<List<Integer>> result1 = exam.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		assertEquals(2, result1.size());
		assertTrue(result1.contains(List.of(-1, -1, 2)));
		assertTrue(result1.contains(List.of(-1, 0, 1)));

		// 2
		List<List<Integer>> result2 = exam.threeSum(new int[] {0, 1, 1});
		assertTrue(result2.isEmpty());

		// 3
		List<List<Integer>> result3 = exam.threeSum(new int[] {0, 0, 0});
		assertEquals(1, result3.size());
		assertTrue(result3.contains(List.of(0, 0, 0)));
	}

	@Test
	void Array_Partition() {
		// 1
		assertEquals(4, new LeetCode_561_ArrayPartition().arrayPairSum(new int[] {1,4,3,2}));

		// 2
		assertEquals(9, new LeetCode_561_ArrayPartition().arrayPairSum(new int[] {6,2,6,5,1,2}));
	}
}
