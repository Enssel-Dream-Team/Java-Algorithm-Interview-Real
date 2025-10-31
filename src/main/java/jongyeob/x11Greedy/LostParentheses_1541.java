package jongyeob.x11Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minusSeperated = reader.readLine().split("-");
        long result = 0;
        if (minusSeperated.length >= 1) {
            for (int i = 1; i < minusSeperated.length; i++) {
                String[] seperated = minusSeperated[i].split("\\+");
                for (String stringNumber : seperated) {
                    result -= Integer.parseInt(stringNumber);
                }
            }
        }
        String[] firstPart = minusSeperated[0].split("\\+");
        for (String stringNumber : firstPart) {
            result += Integer.parseInt(stringNumber);
        }
        System.out.println(result);
    }
}
