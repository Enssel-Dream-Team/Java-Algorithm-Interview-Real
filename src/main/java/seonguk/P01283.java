package seonguk;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P01283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        set.add(' ');

        while (N-- > 0) {
            bw.write(transfer(set, br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String transfer(Set<Character> set, String origin) {
        String upperCase = origin.toUpperCase();
        String[] stringArr = upperCase.split(" ");
        for (int i = 0; i < stringArr.length; i++) {
            char c = stringArr[i].charAt(0);
            if (!set.contains(c)) {
                set.add(c);
                return addParentheses(origin.split(" "), i);
            }
        }

        char[] charArr = upperCase.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (!set.contains(c)) {
                set.add(c);
                return addParentheses(origin.toCharArray(), i);
            }
        }

        return origin;
    }

    static String addParentheses(char[] arr, int idx) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < idx; i++) {
            sb.append(arr[i]);
        }

        sb.append("[").append(arr[idx]).append("]");

        for (int i  = idx + 1; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    static String addParentheses(String[] arr, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(arr[i]).append(" ");
        }

        sb.append("[").append(arr[idx].charAt(0)).append("]").append(arr[idx].substring(1));

        for (int i = idx + 1; i < arr.length; i++) {
            sb.append(" ").append(arr[i]);
        }

        return sb.toString();
    }
}
