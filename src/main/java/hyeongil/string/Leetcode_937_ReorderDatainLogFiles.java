package hyeongil.string;

import java.util.Arrays;

/**

 You are given an array of logs.
 Each log is a space-delimited string of words,
 where the first word is the identifier.

 There are two types of logs:

 Letter-logs: All words (except the identifier) consist of lowercase English letters.
 Digit-logs: All words (except the identifier) consist of digits.
 Reorder these logs so that:

 1. The letter-logs come before all digit-logs.
 2. The letter-logs are sorted lexicographically by their contents.
 If their contents are the same, then sort them lexicographically by their identifiers.

 3. The digit-logs maintain their relative ordering.
 Return the final order of the logs.


 */
// 1. 문자 로그들은 모든 숫자 로그들 이전에 위치한다.
// 2. 문자 로그들은 그 내용들에 대해 사전 순으로 정렬한다.
// 단, 모든 내용이 같다면, 식별자로 정렬을 수행한다.
// 3. 모든 숫자 로그들은 상대 위치를 유지한다.
// -> 숫자 로그 사이에는 정렬을 수행하지 않고, 그대로 유지한다.
// 1. 두 로그가 모두 숫자 로그이면 정렬을 수행하지 않고, 유지한다.
// 2. log1은 숫자 로그, log2가 문자 로그인 경우
// 3. log1, log2 모두 문자 로그인 경우
// 3-1. 식별자를 제외한 로그 내용의 사전 편찬 순으로 정렬을 수행한다.
// 3-2. 식별자의 내용이

public class Leetcode_937_ReorderDatainLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Contents = log1.split(" ");
            String[] log2Contents = log2.split(" ");

            if (isAllDigitLog(log1Contents[1], log2Contents[1])) {
                return 0;
            }

            if (isDigitLog(log1Contents[1]) && isLettersLog(log2Contents)) {
                // log1가 숫자 로그 이므로
                // log1이 log2보다 뒤에 위치해야한다.
                return 1;
            }

            if (isDigitLog(log2Contents[1]) && isLettersLog(log1Contents)) {
                // log2가 숫자 로그이면, log1보다 앞서야한다.
                return -1;
            }

            String log1ContentExceptIdentifier = log1.substring(log1.indexOf(" ") + 1);
            String log2ContentExceptIdentifier = log2.substring(log2.indexOf(" ") + 1);
            return log1ContentExceptIdentifier.compareTo(log2ContentExceptIdentifier) == 0 ? log1Contents[0].compareTo(log2Contents[0]) :
                    log1ContentExceptIdentifier.compareTo(log2ContentExceptIdentifier);
        });
        return logs;
    }

    private static boolean isLettersLog(String[] log2Contents) {
        return !isDigitLog(log2Contents[1]);
    }

    private static boolean isAllDigitLog(String log1Word, String log2Word) {
        return isDigitLog(log1Word) && isDigitLog(log2Word);
    }

    private static boolean isDigitLog(String log1Word) {
        return Character.isDigit(log1Word.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        reorderLogFiles(logs);
        System.out.println(Arrays.toString(logs));
        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        reorderLogFiles(logs2);
        System.out.println(Arrays.toString(logs2));
    }
}
