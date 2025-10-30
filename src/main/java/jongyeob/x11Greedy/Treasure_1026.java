package jongyeob.x11Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Treasure_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arrayA = getDataFromConsole(reader);
        int[] arrayB = getDataFromConsole(reader);
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += ((long)arrayA[i] * arrayB[n - i - 1]);
        }
        System.out.println(result);
    }

    private static int[] getDataFromConsole(BufferedReader reader) throws IOException {
        String[] rawInputs = reader.readLine().split(" ");
        int[] result = new int[rawInputs.length];
        for (int i = 0; i < rawInputs.length; i++) {
            result[i] = Integer.parseInt(rawInputs[i]);
        }
        return result;
    }
}
