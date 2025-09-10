package jongyeob.x03Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfTwoNumber_3273 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sumNumber = Integer.parseInt(br.readLine());
        int result = solve(input, sumNumber);
        System.out.println(result);
    }

    public static int solve(String input, int sumNumber) {
        int[] sortedInput = Arrays.stream(input.split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        int result = 0;
        int left = 0;
        int right = sortedInput.length -1;
        while (left < right) {
            int sum = sortedInput[left] + sortedInput[right];
            if (sum == sumNumber) {
                result++;
                left++;
                right--;
            } else if (sum < sumNumber) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
