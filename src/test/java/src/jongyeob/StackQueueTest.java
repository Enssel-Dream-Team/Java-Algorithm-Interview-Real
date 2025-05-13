package src.jongyeob;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import jongyeob.stackqueue.LeetCode_20_ValidParentheses;

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
}
