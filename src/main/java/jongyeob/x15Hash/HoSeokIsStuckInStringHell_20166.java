package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HoSeokIsStuckInStringHell_20166 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        Character[][] map = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String inputString = reader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputString.charAt(j);
            }
        }
        simulation(map, n, m, hashMap);
        for (int i = 0; i < k; i++) {
            String inputString = reader.readLine();
            System.out.println(hashMap.getOrDefault(inputString, 0));
        }
    }

    private static void simulation(Character[][] map, int n, int m, HashMap<String, Integer> hashMap) {
        char[] selected = new char[5];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                makeWorld(map, n, m, x, y, 0, hashMap, selected);
            }
        }
    }

    private static void makeWorld(Character[][] map, int n, int m, int x, int y, int depth,
        HashMap<String, Integer> hashMap, char[] selected) {
        if (depth == 5) {
            return;
        }
        selected[depth] = map[y][x];
        String result = new String(selected, 0, depth + 1);
        hashMap.put(result, hashMap.getOrDefault(result, 0) + 1);
        for (int[] direction : DIRECTIONS) {
            int nextY = (y + direction[0] + n) % n;
            int nextX = (x + direction[1] + m) % m;
            makeWorld(map, n, m, nextX, nextY, depth + 1, hashMap, selected);
        }

    }

}
