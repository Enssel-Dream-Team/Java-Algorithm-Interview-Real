package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18808 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] notebook = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Sticker sticker = new Sticker(br, r, c);
            attachSticker(notebook, sticker);
        }
        System.out.println(calcStickers(notebook));
        br.close();
    }

    static int calcStickers(boolean[][] notebook) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void attachSticker(boolean[][] notebook, Sticker sticker) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N - sticker.height() + 1; j++) {
                for (int k = 0; k < M - sticker.width() + 1; k++) {
                    if (checkNotebookArea(notebook, sticker, k, j)) {
                        mapStickerToNotebook(notebook, sticker, k, j);
                        return;
                    }
                }
            }

            sticker.rotate();
        }
    }

    static void mapStickerToNotebook(boolean[][] notebook, Sticker sticker, int x, int y) {
        int h = sticker.height();
        int w = sticker.width();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (sticker.sticker[i][j]) {
                    notebook[y + i][x + j] = true;
                }
            }
        }
    }

    static boolean checkNotebookArea(boolean[][] notebook, Sticker sticker, int x, int y) {
        int h = sticker.height();
        int w = sticker.width();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (notebook[y + i][x + j] && sticker.sticker[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Sticker {
        boolean[][] sticker;

        Sticker(BufferedReader br, int r, int c) throws IOException {
            sticker = new boolean[r][c];

            for (int i = 0; i < r; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = st.nextToken().equals("1");
                }
            }
        }

        void rotate() {
            int rotatedR = sticker[0].length;
            int rotatedC = sticker.length;
            boolean[][] rotatedSticker = new boolean[rotatedR][rotatedC];

            for (int i = 0; i < rotatedR; i++) {
                for (int j = 0; j < rotatedC; j++) {
                    rotatedSticker[i][j] = sticker[rotatedC - j - 1][i];
                }
            }
            sticker = rotatedSticker;
        }

        int height() {
            return sticker.length;
        }

        int width() {
            return sticker[0].length;
        }
    }

}
