package jongyeob.x03Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Strfry_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] inputs = new String[N][2];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine().split(" ");
        }
        String[] results = solve(inputs, N);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String[] solve(String[][] inputs, int N) {
        String[] results = new String[N];
        int[] aChar;
        int[] bChar;
        for (int i = 0; i < N; i++) {
            String a = inputs[i][0];
            aChar = getCharArray(a);
            String b = inputs[i][1];
            bChar = getCharArray(b);
            if (Arrays.equals(aChar, bChar)) {
                results[i] = "Possible";
            } else {
                results[i] = "Impossible";
            }
        }
        return results;
    }

    private static int[] getCharArray(String a) {
        int[] charArray = new int[26];
        for (int j = 0; j < a.length(); j++) {
            int index = a.charAt(j) - 'a';
            charArray[index]++;
        }
        return charArray;
    }
}
