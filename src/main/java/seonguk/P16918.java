package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16918 {
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][][] map = new char[4][R][C];
        for (int i = 0; i < R; i++) {
            map[0][i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            Arrays.fill(map[1][i], 'O');
            Arrays.fill(map[2][i], 'O');
            Arrays.fill(map[3][i], 'O');
        }

        setMap(map, 0, 2);
        setMap(map, 2, 3);

        char[][] result;
        if (N == 1) {
            result = map[0];
        } else if (N % 2 == 0) {
            result = map[1];
        } else {
            if (N % 4 == 1) {
                result = map[3];
            } else {
                result = map[2];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    static void setMap(char[][][] map, int ori, int comp) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] oriMap = map[ori];
        char[][] compMap = map[comp];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (oriMap[i][j] == 'O') {
                    compMap[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int fx = j + dx[k];
                        int fy = i + dy[k];
                        if (fx >= 0 && fx < C && fy >= 0 && fy < R) {
                            compMap[fy][fx] = '.';
                        }
                    }
                }
            }
        }
    }

}
