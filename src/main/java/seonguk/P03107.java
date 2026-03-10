package seonguk;

import java.util.Scanner;

public class P03107 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.contains("::")) {
            String[] arr = str.split("::");
            StringBuilder front = new StringBuilder();
            int cnt = 0;
            if (contains(arr[0])) {
                for(String s : arr[0].split(":")) {
                    cnt++;
                    front.append(toOrigin(s)).append(":");
                }
            } else if (!arr[0].isEmpty()) {
                cnt++;
                front.append(toOrigin(arr[0])).append(":");
            }

            StringBuilder back = new StringBuilder();
            if (arr.length > 1) {
                if (contains(arr[1])) {
                    for(String s : arr[1].split(":")) {
                        cnt++;
                        back.append(toOrigin(s)).append(":");
                    }
                } else if (!arr[1].isEmpty()) {
                    cnt++;
                    back.append(toOrigin(arr[1])).append(":");
                }
                back.deleteCharAt(back.length() - 1);
            } else {
                back.append("0000:".repeat(8 - cnt));
                back.deleteCharAt(back.length() - 1);
                cnt = 8;
            }
            System.out.println(front + "0000:".repeat(8 - cnt) + back);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : str.split(":")) {
                sb.append(toOrigin(s)).append(":");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
        scan.close();
    }

    static String toOrigin(String str) {
        return "0".repeat(4 - str.length()) + str;
    }

    static boolean contains(String str) {
        return str.contains(":");
    }

    static String[] toArray(String str) {
        return str.split(":");
    }
}
