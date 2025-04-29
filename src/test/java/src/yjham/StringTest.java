package src.yjham;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

import src.yjham.string.LeetCode_49_GroupAnagrams;
import src.yjham.string.LeetCode_5_LongestPalindromicSubstring;
import src.yjham.string.LeetCode_819_MostCommonWord;
import src.yjham.string.LeetCode_937_ReorderLogFiles;
import src.yjham.string.LeetCode_344_ReverseString;
import src.yjham.string.LeetCode_125_ValidPalindrome;

@DisplayName("6_문자열 처리 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringTest {

	@Test
	void Valid_Palindrome() {
		LeetCode_125_ValidPalindrome exam = new LeetCode_125_ValidPalindrome();

		// 1
		assertThat(exam.isPalindrome("A man, a plan, a canal: Panama")).isTrue();

		// 2
		assertThat(exam.isPalindrome("race a car")).isFalse();

		// 3
		assertThat(exam.isPalindrome("")).isTrue();
	}

	@Test
	void Reverse_String() {
		LeetCode_344_ReverseString exam = new LeetCode_344_ReverseString();

		// 1
		char[] s = {'h','e','l','l','o'};
		exam.reverseString(s);

		assertThat(s).isEqualTo(new char[]{'o','l','l','e','h'});

		// 2
		char[] s2 = {'H','a','n','n','a','h'};
		exam.reverseString(s2);

		assertThat(s2).isEqualTo(new char[]{'h','a','n','n','a','H'});
	}

	@Test
	void Reorder_Log_Files() {
		LeetCode_937_ReorderLogFiles exam = new LeetCode_937_ReorderLogFiles();

		// 1
		assertThat(exam.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}))
			.isEqualTo(new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"});

		// 2
		assertThat(exam.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"}))
			.isEqualTo(new String[]{"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"});
	}

	@Test
	void Most_Common_Word() {
		LeetCode_819_MostCommonWord exam = new LeetCode_819_MostCommonWord();

		// 1
		assertThat(
			exam.mostCommonWord(
				"Bob hit a ball, the hit BALL flew far after it was hit.",
				new String[]{"hit"}
			)
		).isEqualTo("ball");

		// 2
		assertThat(
			exam.mostCommonWord(
				"a.",
				new String[]{}
			)
		).isEqualTo("a");
	}

	@Test
	void Group_Anagrams() {
		LeetCode_49_GroupAnagrams exam = new LeetCode_49_GroupAnagrams();

		// 1
		List<List<String>> actual = exam.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

		assertThat(actual)
			.hasSize(3)
			.satisfies(list -> {
				assertThat(list).anySatisfy(group ->
					assertThat(group).containsExactlyInAnyOrder("eat", "tea", "ate"));
				assertThat(list).anySatisfy(group ->
					assertThat(group).containsExactlyInAnyOrder("tan", "nat"));
				assertThat(list).anySatisfy(group ->
					assertThat(group).containsExactlyInAnyOrder("bat"));
			});

		// 2
		List<List<String>> actual2 = exam.groupAnagrams(new String[] {""});

		assertThat(actual2)
			.hasSize(1)
			.satisfies(list -> {
				assertThat(list).anySatisfy(group ->
					assertThat(group).containsExactlyInAnyOrder(""));
			});

		// 3
		List<List<String>> actual3 = exam.groupAnagrams(new String[] {"a"});

		assertThat(actual3)
			.hasSize(1)
			.satisfies(list -> {
				assertThat(list).anySatisfy(group ->
					assertThat(group).containsExactlyInAnyOrder("a"));
			});
	}

	@Test
	void Longest_Palindromic_Substring() {
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("babad")).isEqualTo("bab");
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("cbbd")).isEqualTo("bb");
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("a")).isEqualTo("a");
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("ac")).isEqualTo("a");
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("ccc")).isEqualTo("ccc");
		assertThat(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome("aaaa")).isEqualTo("aaaa");
	}
}
