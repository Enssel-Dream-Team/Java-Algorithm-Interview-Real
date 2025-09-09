package src.jongyeob;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import jongyeob.x03Array.NumberOfAlphabet_10808;
import jongyeob.x03Array.Stack_10828;

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

    @Test
    void 알파벳_개수_10808() {
        // Case 1
        String case1Input = "baekjoon";
        int[] case1Result = {1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(case1Result, NumberOfAlphabet_10808.solve(case1Input));

    }
}
