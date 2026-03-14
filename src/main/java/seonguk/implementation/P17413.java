package seonguk.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P17413 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = scan.nextLine().toCharArray();
        List<MyString> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char c : arr) {
            if (c == '<') {
                flag = true;
                if (sb.length() > 0) {
                    list.add(new MyString(sb.toString(), true));
                }
                sb = new StringBuilder();
                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
                list.add(new MyString(sb.toString(), false));
                sb = new StringBuilder();
            } else if (c == ' ' && !flag) {
                list.add(new MyString(sb.toString(), true));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            list.add(new MyString(sb.toString(), true));
        }

        StringBuilder result = new StringBuilder();
        for (MyString myString : list) {
            if (myString.isWord) {
                myString.reverse();
                result.append(myString.str);
                result.append(" ");
            } else {
                if (result.length() > 0 && result.lastIndexOf(" ") == result.length() - 1) {
                    result.deleteCharAt(result.length() - 1);
                }
                result.append(myString.str);
            }
        }

        System.out.println(result.toString());

        scan.close();
    }

    static class MyString {
        boolean isWord;
        String str;

        public MyString(String str, boolean isWord) {
            this.str = str;
            this.isWord = isWord;
        }

        public void reverse() {
            if (isWord) {
                StringBuilder builder = new StringBuilder(this.str);
                this.str = builder.reverse().toString();
            }
        }
    }
}
