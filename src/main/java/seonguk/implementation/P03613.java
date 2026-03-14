package seonguk.implementation;

import java.util.Scanner;

public class P03613 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        if (!isValid(str)) {
            System.out.println("Error!");
            return;
        }

        String result;
        if (str.contains("_")) {
            result = toCamelCase(str);
        } else {
            result = toSnakeCase(str);
        }
        System.out.println(result);
        scan.close();
    }

    static String toCamelCase(String str) {
        String[] arr = str.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append((char)(arr[i].charAt(0) - 'a' + 'A')).append(arr[i].substring(1));
        }
        return sb.toString();
    }

    static String toSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append("_").append((char)(c - 'A' + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static boolean isValid(String str) {
        if (str.charAt(0) == '_') {
            return false;
        }
        if (str.charAt(str.length() - 1) == '_') {
            return false;
        }
        if (str.contains("__")) {
            return false;
        }
        return (str.equals(str.toLowerCase()) || !str.contains("_")) && (str.charAt(0) >= 'a' && str.charAt(0) <= 'z');
    }
}
