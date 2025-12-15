package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TwoDimensionalArrayAndOperation_17140 {
    private static int r;
    private static int c;
    private static int k;
    private static int columnLength = 3;
    private static int rowLength = 3;
    private static int[][] map = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(tokenizer.nextToken()) - 1;
        c = Integer.parseInt(tokenizer.nextToken()) - 1;
        k = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < 3; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        for (int i = 0; i < 101; i++) {
            if (map[r][c] == k)
                return i;
            if (rowLength >= columnLength) {
                rowSort();
            } else {
                columnSort();
            }
        }
        return -1;
    }

    private static void columnSort() {
        int newRowLength = 0;
        for (int colNumber = 0; colNumber < columnLength; colNumber++) {
            int[] count = new int[101];
            List<Pair> pairs = new ArrayList<>();
            int rowIdx = 0;
            while (rowIdx < rowLength) {
                if (map[rowIdx][colNumber] == 0) {
                    rowIdx++;
                    continue;
                }
                count[map[rowIdx++][colNumber]]++;
            }
            for (int i = 1; i < 101; i++) {
                if (count[i] == 0)
                    continue;
                pairs.add(new Pair(i, count[i]));
            }
            Collections.sort(pairs);
            int maxRow = pairs.size() * 2 > 100 ? 50 : pairs.size();
            int[] temp = new int[100];
            for (int i = 0; i < maxRow; i++) {
                Pair current = pairs.get(i);
                temp[i * 2] = current.number;
                temp[i * 2 + 1] = current.count;
            }
            for (int i = 0; i < 100; i++) {
                map[i][colNumber] = temp[i];
            }
            newRowLength = Math.max(newRowLength, maxRow * 2);
        }
        rowLength = Math.min(100, newRowLength);

    }

    private static void rowSort() {
        int newColumnLength = 0;
        for (int rowNumber = 0; rowNumber < rowLength; rowNumber++) {
            int[] count = new int[101];
            List<Pair> pairs = new ArrayList<>();
            int colIdx = 0;
            while (colIdx < columnLength) {
                if (map[rowNumber][colIdx] == 0) {
                    colIdx++;
                    continue;
                }
                count[map[rowNumber][colIdx++]]++;
            }
            for (int i = 1; i < 101; i++) {
                if (count[i] == 0)
                    continue;
                pairs.add(new Pair(i, count[i]));
            }
            Collections.sort(pairs);
            int maxColumn = pairs.size() * 2 > 100 ? 50 : pairs.size();
            int[] temp = new int[100];
            for (int i = 0; i < maxColumn; i++) {
                Pair current = pairs.get(i);
                temp[i * 2] = current.number;
                temp[i * 2 + 1] = current.count;
            }
            map[rowNumber] = temp;
            newColumnLength = Math.max(newColumnLength, maxColumn * 2);
        }
        columnLength = Math.min(100, newColumnLength);
    }

    private static class Pair implements Comparable<Pair> {
        int number;
        int count;

        public Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count == o.count) {
                return Integer.compare(this.number, o.number);
            } else {
                return Integer.compare(this.count, o.count);
            }
        }
    }
}
