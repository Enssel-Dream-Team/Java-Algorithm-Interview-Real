package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import yjham.dequePriorityQueue.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("10_데크,우선순위 큐 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DequePriorityQueueTest {

    @Test
    void Design_Circular_Deque_Test () {
        LeetCode_641_DesignCircularDeque exam = new LeetCode_641_DesignCircularDeque();

        String[] commands = {"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"};
        Integer[] inputs = {3, 1, 2, 3, 4, null, null, null, 4, null};

        Object[] expected = {null, true, true, true, false, 2, true, true, true, 4};
        Object[] actual = exam.useMyCircularDeque(commands, inputs);

        assertArrayEquals(expected, actual);
    }
}
