package jongyeob.x03Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateAnagram_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();
        int result = solve(inputA, inputB);
        System.out.println(result);
    }

    private static int solve(String inputA, String inputB) {
        int[] aChar = getCharArray(inputA);
        int[] bChar = getCharArray(inputB);
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if(aChar[i] !=  bChar[i]){
                int numOfRemove = aChar[i] - bChar[i];
                result+= Math.abs(numOfRemove);
            }
        }
        return result;
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
