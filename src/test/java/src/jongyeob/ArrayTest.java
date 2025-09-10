package src.jongyeob;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import jongyeob.x03Array.Counting_10807;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import jongyeob.x03Array.NumOfNumber_2577;
import jongyeob.x03Array.NumberOfAlphabet_10808;
import jongyeob.x03Array.RoomNumber_1475;
import jongyeob.x03Array.Stack_10828;
import jongyeob.x03Array.SumOfTwoNumber_3273;

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

    @Test
    void 숫자의_숫자_2577(){
        // Case 1
        int[] case1Input = new int[] { 150,266,427};
        int[] case1Result = new int[]{3,1,0,2,0,0,0,2,0,0    };
        assertArrayEquals(case1Result, NumOfNumber_2577.solve(case1Input[0], case1Input[1], case1Input[2]));
    }

    @Test
    void 개수_세기_10807(){
        // Case 1
        int[] case1InputArray = new int[]{1,4,1,2,4,2,4,2,3,4,4};
        int case1InputV = 2;
        int case1Result = 3;
        assertEquals(case1Result, Counting_10807.solve(case1InputArray, case1InputV));

        // Case 2
        int[] case2InputArray = new int[]{1,4,1,2,4,2,4,2,3,4,4};
        int case2InputV = 5;
        int case2Result = 0;
        assertEquals(case2Result, Counting_10807.solve(case2InputArray, case2InputV));
    }

    @ParameterizedTest
    @CsvSource({
        "9999, 2",
        "122, 2",
        "12635, 1",
        "888888, 6",
        "1122, 2",
        "699, 2",
    })
    void 방_번호_1475(int caseInput, int caseResult){
        // Case 1
        assertEquals(caseResult, RoomNumber_1475.solve(caseInput));
    }

    @ParameterizedTest
    @CsvSource({
        "5 12 7 10 9 1 2 3 11, 13, 3",
    })
    void 두_수의_합_1475(String caseInputArray, int caseInputSum ,int caseResult){
        assertEquals(caseResult, SumOfTwoNumber_3273.solve(caseInputArray, caseInputSum));
    }
}
