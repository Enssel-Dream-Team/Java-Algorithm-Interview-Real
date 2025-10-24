package jongyeob.x05Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
7
2
4
1
2
2
5
1

10
 */
public class OasisReunion3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(reader.readLine());
        }
        int result = solve(input);
    }

    private static int solve(int[] input) {

        return 0;
    }
}
