package jongyeob.x0CBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class MakePassword_1759 {
    private static final Set<String> vowels = Set.of("a", "e", "i", "o", "u");
    private static int L, C;
    private static String[] inputs;
    private static boolean[] isVowel;
    private static String[] tempResult;
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        L = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        tempResult = new String[L];
        inputs = new String[C];
        isVowel = new boolean[C];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < C; i++) {
            inputs[i] = tokenizer.nextToken();
        }
        Arrays.sort(inputs);
        for (int i = 0; i < C; i++) {
            isVowel[i] = vowels.contains(inputs[i]);
        }
        backtracking(0, 0, 0, 0);

        System.out.println(builder);

    }

    private static void backtracking(int start, int depth, int numOfVowel, int numOfConsonant) {
        if (depth == L) {
            if (numOfVowel > 0 && numOfConsonant > 1) {
                for (String s : tempResult) {
                    builder.append(s);
                }
                builder.append('\n');
            }
            return;
        }
        for (int i = start; i < C; i++) {
            tempResult[depth] = inputs[i];
            backtracking(i + 1, depth + 1, isVowel[i] ? numOfVowel + 1 : numOfVowel,
                isVowel[i] ? numOfConsonant : numOfConsonant + 1);
        }

    }
}
