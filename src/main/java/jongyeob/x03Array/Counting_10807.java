package jongyeob.x03Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Counting_10807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(br.readLine());

        int result = solve(input, v);
        System.out.println(result);
    }

    public static int solve(int[] input, int v) {
        int result = 0;
        for (int i : input) {
            if (i == v) {
                result++;
            }
        }
        return result;
    }

}
