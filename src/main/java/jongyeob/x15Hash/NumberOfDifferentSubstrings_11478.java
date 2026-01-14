package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NumberOfDifferentSubstrings_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        HashSet<String> hashSet = new HashSet<>();
        for (int len = 1; len <= inputString.length(); len++) {
            for (int i = 0; i + len <= inputString.length(); i++) {
                hashSet.add(inputString.substring(i, i + len));
            }
        }
        System.out.println(hashSet.size());
    }
}
