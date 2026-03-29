package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01132 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Alphabet[] weights = setInit();
        boolean[] isFirst = new boolean[10];
        String[] strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
            char[] arr = strArr[i].toCharArray();
            int len = arr.length;
            isFirst[arr[0] - 'A'] = true;

            for (int j = 0; j < len; j++) {
                weights[arr[j] - 'A'].addWeight((long) Math.pow(10, len - j - 1));
            }
        }
        Arrays.sort(weights);

        if (isFirst[weights[9].c - 'A']) {
            for (int i = 8; i >= 0; i--) {
                if (!isFirst[weights[i].c - 'A']) {
                    weights[i].setZero();
                    break;
                }
            }
        }
        Arrays.sort(weights);

        toNumber(strArr, weights);

        long ans = 0;
        for (String str : strArr) {
            ans += Long.parseLong(str);
        }

        System.out.println(ans);
        br.close();
    }

    static void toNumber(String[] strArr, Alphabet[] weights) {
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            for (int j = 0; j < 10; j++) {
                Alphabet alphabet = weights[j];
                if (!alphabet.isUsed) {
                    break;
                }
                str = str.replace(alphabet.c, (char) ((9 - j) + '0'));
            }
            strArr[i] = str;
        }
    }

    static Alphabet[] setInit() {
        Alphabet[] alphabets = new Alphabet[10];
        for (int i = 0; i < 10; i++) {
            alphabets[i] = new Alphabet((char) ('A' + i));
        }
        return alphabets;
    }

    static class Alphabet implements Comparable<Alphabet> {
        char c;
        long weight;
        boolean isUsed;

        public Alphabet(char c) {
            this.c = c;
            this.weight = 0;
        }

        public void addWeight(long weight) {
            this.weight += weight;
            this.isUsed = true;
        }

        public void setZero() {
            this.weight = 0;
        }

        @Override
        public int compareTo(Alphabet o) {
            if (this.weight < o.weight) {
                return 1;
            } else if (this.weight > o.weight) {
                return -1;
            }
            return isUsed ? 0 : 1;
        }
    }
}
