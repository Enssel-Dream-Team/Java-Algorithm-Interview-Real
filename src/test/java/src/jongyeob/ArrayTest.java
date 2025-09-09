package src.jongyeob;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import jongyeob.array.LeetCode_238_ProductOfArrayExceptSelf;

public class ArrayTest {
    @Test
    void 스택_10828번() {
        // Case 1
        String[] case1Input = new String[] {
            "push 1", "push 2", "top", "size", "empty", "pop", "pop", "pop", "size", "empty", "pop", "push 3", "empty",
            "top"
        };
        int[] case1Result = {2, 2, 0, 2, 1, -1, 0, 1, -1, 0, 3};
        assertArrayEquals(case1Result, Stack_10828.solve(case1Input));

        // Case 2
        String[] case2Input = new String[] {"pop", "top", "push 123", "top", "pop", "top", "pop"};
        int[] case2Result = {-1, -1, 123, 123, -1, -1};
        assertArrayEquals(case2Result, Stack_10828.solve(case2Input));

    }

		// 2
		assertArrayEquals(new int[] {-1,1}, exam.productExceptSelf(new int[] {1,-1}));

	}
}
