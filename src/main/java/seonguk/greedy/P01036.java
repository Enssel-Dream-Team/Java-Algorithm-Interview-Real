package seonguk.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01036 {

    static Map<Character, Integer> mapCharToInt = new HashMap<>();
    static Map<Integer, Character> mapIntToChar = new HashMap<>();

    public static void main(String[] args) throws IOException {
        setInit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] strArr = new String[N];
        Map<Character, Weight> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strArr[i] = str;
            char[] charArr = str.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                char c = charArr[j];
                Weight w = map.getOrDefault(c, new Weight(c));
                w.addWeight(charArr.length - j - 1);
                map.put(c, w);
            }
        }

        PriorityQueue<Weight> pq = new PriorityQueue<>();
        map.forEach((k, v) -> {
            v.calcWeight();
            pq.add(v);
        });

        int K = Integer.parseInt(br.readLine());
        while (!pq.isEmpty() && K-- > 0) {
            Weight w = pq.poll();
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = strArr[i].replace(w.c, 'Z');
            }
        }

        System.out.println(calcResult(strArr));
    }

    static String calcResult(String[] strArr) {
        int[] result = new int[52];
        for (String s : strArr) {
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                result[charArr.length - i - 1] += mapCharToInt.get(charArr[i]);
            }
        }

        for (int i = 0; i < 51; i++) {
            if (result[i] < 36) {
                continue;
            }
            result[i + 1] += result[i] / 36;
            result[i] %= 36;
        }

        StringBuilder sb = new StringBuilder();
        int firstIdx = 0;
        for (int i = 51; i >= 0; i--) {
            if (result[i] > 0) {
                firstIdx = i;
                break;
            }
        }

        for (int i = firstIdx; i >= 0; i--) {
            sb.append(mapIntToChar.get(result[i]));
        }
        return sb.toString();
    }

    static void setInit() {
        for (int i = 0; i < 10; i++) {
            mapCharToInt.put((char)('0' + i), i);
            mapIntToChar.put(i, (char)('0' + i));
        }
        for (int i = 0; i < 26; i++) {
            mapCharToInt.put((char)('A' + i), i + 10);
            mapIntToChar.put(i + 10, (char)('A' + i));
        }
    }

    static class Weight implements Comparable<Weight> {
        char c;
        int[] weights = new int[52];

        Weight(char c) {
            this.c = c;
        }

        public void addWeight(int idx) {
            weights[idx] += (35 - mapCharToInt.get(c));
        }

        public void calcWeight() {
            for (int i = 0; i < 51; i++) {
                if (weights[i] < 36) {
                    continue;
                }

                weights[i + 1] += weights[i] / 36;
                weights[i] %= 36;
            }
        }

        @Override
        public int compareTo(Weight o) {
            if (this.c == 'Z') {
                return 1;
            }
            if (o.c == 'Z') {
                return -1;
            }

            for (int i = 51; i >= 0; i--) {
                if (this.weights[i] != o.weights[i]) {
                    return o.weights[i] - this.weights[i];
                }
            }
            return this.c - o.c;
        }
    }
}
