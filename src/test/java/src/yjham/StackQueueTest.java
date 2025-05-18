package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import yjham.stackQueue.*;

@DisplayName("9_스택,큐 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StackQueueTest {

	@Test
	void Valid_Parentheses() {
		LeetCode_20_ValidParentheses exam = new LeetCode_20_ValidParentheses();

		assertTrue(exam.isValid("()"));
		assertTrue(exam.isValid("()[]{}"));
		assertFalse(exam.isValid("(]"));
		assertTrue(exam.isValid("([])"));
		assertTrue(exam.isValid("([{}])"));
		assertTrue(exam.isValid("[{()}]"));
		assertFalse(exam.isValid("([)]"));
		assertFalse(exam.isValid("([)]"));
		assertFalse(exam.isValid("([)]"));
		assertFalse(exam.isValid("([)]"));
		assertFalse(exam.isValid("("));
	}

	@Test
	void Daily_Temperatures() {
		LeetCode_739_DailyTemperatures exam = new LeetCode_739_DailyTemperatures();

		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

		int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
		int[] actual = exam.dailyTemperatures(temperatures);

		assertArrayEquals(expected, actual);

		temperatures = new int[]{30, 40, 50, 60};

		expected = new int[]{1, 1, 1, 0};
		actual = exam.dailyTemperatures(temperatures);

		assertArrayEquals(expected, actual);

		temperatures = new int[]{30, 60, 90};

		expected = new int[]{1, 1, 0};
		actual = exam.dailyTemperatures(temperatures);

		assertArrayEquals(expected, actual);
	}

	@Test
	void Implement_Stack_Using_Queues() {
		LeetCode_225_ImplementStackUsingQueues exam = new LeetCode_225_ImplementStackUsingQueues();

		String[] commands = {"MyStack", "push", "push", "top", "pop", "empty"};
		Integer[] inputs = {null, 1, 2, null, null, null};

		Object[] expected = {null, null, null, 2, 2, false};
		Object[] actual = exam.useMyStack(commands, inputs);

		assertArrayEquals(expected, actual);
	}

	@Test
	void Implement_Queue_Using_Stacks() {
		LeetCode_232_ImplementQueueUsingStacks exam = new LeetCode_232_ImplementQueueUsingStacks();

		String[] commands = {"MyQueue", "push", "push", "peek", "pop", "empty"};
		Integer[] inputs = {null, 1, 2, null, null, null};

		Object[] expected = {null, null, null, 1, 1, false};
		Object[] actual = exam.useMyQueue(commands, inputs);

		assertArrayEquals(expected, actual);
	}
}
