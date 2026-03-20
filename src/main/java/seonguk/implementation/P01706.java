package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01706 {

    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        List<String> list = new ArrayList<>();

        findHorizontalWords(map, list);
        findVerticalWords(map, list);

        Collections.sort(list);
        System.out.println(list.get(0));
        br.close();
    }

    private static void findHorizontalWords(char[][] map, List<String> words) {
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                makeWord(words, sb, map[i][j]);
            }
            addWord(sb.toString(), words);
        }
    }

    private static void findVerticalWords(char[][] map, List<String> words) {
        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                makeWord(words, sb, map[i][j]);
            }
            addWord(sb.toString(), words);
        }
    }

    private static void makeWord(List<String> words, StringBuilder sb, char c) {
        if (c == '#') {
            addWord(sb.toString(), words);
            sb.delete(0, sb.length());
        } else {
            sb.append(c);
        }
    }

    private static void addWord(String str, List<String> words) {
        if (str.length() > 1) {
            words.add(str);
        }
    }
}
