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
	void Implement_Queue_Using_Stacks() {
		LeetCode_232_ImplementQueueUsingStacks exam = new LeetCode_232_ImplementQueueUsingStacks();

		String[] commands = {"MyQueue", "push", "push", "peek", "pop", "empty"};
		Integer[] inputs = {null, 1, 2, null, null, null};

		assertArrayEquals(new Object[]{null, null, null, 1, 1, false}, exam.useMyQueue(commands, inputs));
	}
}
