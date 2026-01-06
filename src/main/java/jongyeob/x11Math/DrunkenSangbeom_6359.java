package jongyeob.x11Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrunkenSangbeom_6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            result[i] = solve(Integer.parseInt(reader.readLine()));
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int solve(int n) {
        boolean[] rooms = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * i < n + 1; j++) {
                rooms[j * i] = !rooms[j * i];
            }
        }
        int opened = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!rooms[i])
                opened++;
        }
        return opened;
    }
}
