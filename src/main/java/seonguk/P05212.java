package seonguk;

import java.io.*;
import java.util.StringTokenizer;

public class P05212 {

    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        char[][] nextMap = afterFiftyYears(map);
        for (char[] row : nextMap) {
            bw.write(String.valueOf(row) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static char[][] afterFiftyYears(char[][] map) {
        char[][] disappearedMap = initNextMap(map);
        return cutMap(disappearedMap);
    }

    private static char[][] cutMap(char[][] map) {
        int startRowIdx = 0;
        int startColIdx = 0;
        int endRowIdx = R - 1;
        int endColIdx = C - 1;

        flag:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    startRowIdx = i;
                    break flag;
                }
            }
        }

        flag:
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    endRowIdx = i;
                    break flag;
                }
            }
        }

        flag:
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (map[i][j] == 'X') {
                    startColIdx = j;
                    break flag;
                }
            }
        }

        flag:
        for (int j = C - 1; j >= 0; j--) {
            for (int i = 0; i < R; i++) {
                if (map[i][j] == 'X') {
                    endColIdx = j;
                    break flag;
                }
            }
        }

        int r = endRowIdx - startRowIdx + 1;
        int c = endColIdx - startColIdx + 1;
        char[][] newMap = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMap[i][j] = map[startRowIdx + i][startColIdx + j];
            }
        }
        return newMap;
    }

    private static char[][] initNextMap(char[][] map) {
        char[][] nextMap = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                nextMap[i][j] = map[i][j];
                if (map[i][j] == 'X' && checkAround(map, j, i)) {
                    nextMap[i][j] = '.';
                }
            }
        }
        return nextMap;
    }

    private static boolean checkAround(char[][] map, int x, int y) {
        int cnt =0;
        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];
            if (fx < 0 || fx >= C || fy < 0 || fy >= R || map[fy][fx] == '.') {
                cnt++;
            }
        }

        return cnt >= 3;
    }
}
