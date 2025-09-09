package jongyeob.x03Array;

import java.util.Scanner;

public class NumberOfAlphabet_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();

        int[] results = solve(input);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    public static int[] solve(String input){
        int[] result = new int[26];
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            result[ch-'a'] += 1;
        }
        return result;
    }
}
