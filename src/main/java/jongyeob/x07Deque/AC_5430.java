package jongyeob.x07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        String[] results = new String[T];

        for (int t = 0; t < T; t++) {
            String command = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            String arrLine = reader.readLine();

            int[] arr;
            if (n == 0) {
                arr = new int[0];
            } else {
                arr = Arrays.stream(
                        arrLine.substring(1, arrLine.length() - 1)
                            .split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            }

            results[t] = solve(arr, command);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String solve(int[] input, String command) {
        int left = 0;
        int right = input.length - 1;
        boolean reversed = false;
        int size = input.length;

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                reversed = !reversed;
            } else { // 'D'
                if (size == 0)
                    return "error";
                if (!reversed) {
                    left++;
                } else {
                    right--;
                }
                size--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            if (!reversed) {
                for (int i = left; i <= right; i++) {
                    sb.append(input[i]);
                    if (i != right)
                        sb.append(',');
                }
            } else {
                for (int i = right; i >= left; i--) {
                    sb.append(input[i]);
                    if (i != left)
                        sb.append(',');
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
