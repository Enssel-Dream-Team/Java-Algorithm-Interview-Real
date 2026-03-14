package seonguk.implementation;

import java.util.Scanner;

public class P01213 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'A']++;
        }

        if (!inputCheck(arr)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Character center = null;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            String str = String.valueOf(c).repeat(arr[i] / 2);
            sb.append(str);
            if (arr[i] % 2 == 1) {
                center = c;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(sb);
        if (center != null) {
            result.append(center);
        }
        result.append(sb.reverse());
        System.out.println(result);
    }

    private static boolean inputCheck(int[] arr) {
        int cnt = 0;
        for (int val : arr) {
            if (val % 2 == 1) {
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
