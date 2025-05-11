package src.jongyeob;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import jongyeob.array.LeetCode_238_ProductOfArrayExceptSelf;

public class ArrayTest {
	@Test
	void Product_of_Array_Except_Self_Test() {
		LeetCode_238_ProductOfArrayExceptSelf exam = new LeetCode_238_ProductOfArrayExceptSelf();

		// 1
		assertArrayEquals(new int[] {24, 12, 8, 6}, exam.productExceptSelf(new int[] {1, 2, 3, 4}));

		// 2
		assertArrayEquals(new int[] {0, 0, 9, 0, 0}, exam.productExceptSelf(new int[] {-1, 1, 0, -3, 3}));

		// 2
		assertArrayEquals(new int[] {-1,1}, exam.productExceptSelf(new int[] {1,-1}));

	}
}
