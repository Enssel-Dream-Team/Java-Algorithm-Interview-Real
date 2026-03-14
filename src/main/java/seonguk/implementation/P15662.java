package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15662 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        Gear[] gears = new Gear[T];
        for (int i = 0; i < T; i++) {
            gears[i] = new Gear(br.readLine());
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int rotationDir = Integer.parseInt(st.nextToken());
            if (rotationDir == 1) {
                rotateC(gears, idx);
            } else {
                rotateR(gears, idx);
            }
        }

        int ans = 0;
        for (Gear gear : gears) {
            if (gear.isS()) {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static void rotateC(Gear[] gears, int idx) {
        Gear.OriTooth tooth = gears[idx].rotateC();
        rotateLeftGears(gears, idx, true, tooth.left);
        rotateRightGears(gears, idx, true, tooth.right);
    }

    static void rotateR(Gear[] gears, int idx) {
        Gear.OriTooth tooth = gears[idx].rotateR();
        rotateLeftGears(gears, idx, false, tooth.left);
        rotateRightGears(gears, idx, false, tooth.right);
    }


    static void rotateLeftGears(Gear[] gears, int idx, boolean isC, char c) {
        for (int i = idx - 1; i >= 0; i--) {
            if (!gears[i].canRotateCompRight(c)) {
                break;
            }

            if (isC) {
                c = gears[i].rotateR().left;
            } else {
                c = gears[i].rotateC().left;
            }
            isC = !isC;
        }
    }

    static void rotateRightGears(Gear[] gears, int idx, boolean isC, char c) {
        for (int i = idx + 1; i < T; i++) {
            if (!gears[i].canRotateCompLeft(c)) {
                break;
            }

            if (isC) {
                c = gears[i].rotateR().right;
            } else {
                c = gears[i].rotateC().right;
            }
            isC = !isC;
        }
    }

    static class Gear {
        char[] teeth;
        int leftIdx;
        static final int TOOTH_CNT = 8;

        public Gear(String str) {
            teeth = str.toCharArray();
            leftIdx = 6;
        }

        public OriTooth rotateC() {
            OriTooth result = new OriTooth(teeth[leftIdx], teeth[(leftIdx + 4) % TOOTH_CNT]);
            leftIdx = (leftIdx + 7) % TOOTH_CNT;
            return result;
        }

        public OriTooth rotateR() {
            OriTooth result = new OriTooth(teeth[leftIdx], teeth[(leftIdx + 4) % TOOTH_CNT]);
            leftIdx = (leftIdx + 1) % TOOTH_CNT;
            return result;
        }

        public boolean isS() {
            return teeth[(leftIdx + 2) % TOOTH_CNT] == '1';
        }

        public boolean canRotateCompRight(char c) {
            return teeth[(leftIdx + 4) % TOOTH_CNT] != c;
        }

        public boolean canRotateCompLeft(char c) {
            return teeth[leftIdx] != c;
        }

        static class OriTooth {
            char left;
            char right;

            public OriTooth(char left, char right) {
                this.left = left;
                this.right = right;
            }
        }
    }

}
