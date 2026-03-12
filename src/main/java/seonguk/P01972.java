package seonguk;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P01972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while (!str.equals("*")) {
            char[] arr = str.toCharArray();
            if (isSurprising(arr)) {
                bw.write(str + " is surprising.");
            } else {
                bw.write(str + " is NOT surprising.");
            }
            bw.newLine();
            str = br.readLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isSurprising(char[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < arr.length - i; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[j]);
                sb.append(arr[j + i]);
                if (set.contains(sb.toString())) {
                    return false;
                }
                set.add(sb.toString());
            }
        }
        return true;
    }

}
