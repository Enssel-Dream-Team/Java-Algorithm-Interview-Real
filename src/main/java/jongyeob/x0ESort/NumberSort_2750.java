package jongyeob.x0ESort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSort_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(inputs);

        StringBuilder builder = new StringBuilder();
        for (int input : inputs) {
            builder.append(input).append('\n');
        }
        System.out.println(builder);
    }
}
