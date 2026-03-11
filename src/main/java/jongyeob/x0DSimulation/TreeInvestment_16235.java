package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class TreeInvestment_16235 {
    private static final int[] dy = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[][] origin = new int[n][n];
        int[][] garden = new int[n][n];
        Deque<Integer>[][] trees = new ArrayDeque[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                trees[i][j] = new ArrayDeque<>();
                origin[i][j] = Integer.parseInt(tokenizer.nextToken());
                garden[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(tokenizer.nextToken()) - 1;
            int x = Integer.parseInt(tokenizer.nextToken()) - 1;
            int age = Integer.parseInt(tokenizer.nextToken());
            trees[y][x].add(age);
        }

        int result = simulation(n, k, origin, garden, trees);
        System.out.println(result);
    }

    private static int simulation(int n, int k, int[][] origin, int[][] garden, Deque<Integer>[][] trees) {
        for (int i = 0; i < k; i++) {
            Deque<Integer>[][] deadTrees = spring(n, garden, trees);
            summer(n, garden, deadTrees);
            fall(n, garden, trees);
            winter(n, garden, origin);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!trees[i][j].isEmpty()) {
                    result += trees[i][j].size();
                }
            }
        }
        return result;
    }

    private static void winter(int n, int[][] garden, int[][] origin) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                garden[i][j] += origin[i][j];
            }
        }
    }

    private static void fall(int n, int[][] garden, Deque<Integer>[][] trees) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!trees[i][j].isEmpty()) {
                    for (Integer tree : trees[i][j]) {
                        if (tree % 5 == 0) {
                            for (int k = 0; k < 8; k++) {
                                int ny = i + dy[k];
                                int nx = j + dx[k];
                                if (ny < n && ny >= 0 && nx < n && nx >= 0) {
                                    trees[ny][nx].addFirst(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void summer(int n, int[][] garden, Deque<Integer>[][] deadTrees) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!deadTrees[i][j].isEmpty()) {
                    int sum = 0;
                    for (int tree : deadTrees[i][j]) {
                        sum += (tree / 2);
                    }
                    garden[i][j] += sum;
                }
            }
        }
    }

    private static Deque<Integer>[][] spring(int n, int[][] garden, Deque<Integer>[][] trees) {
        Deque<Integer>[][] deadTrees = new ArrayDeque[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                deadTrees[i][j] = new ArrayDeque<>();
                if (!trees[i][j].isEmpty()) {
                    Deque<Integer> placedTrees = trees[i][j];
                    int size = placedTrees.size();
                    for (int k = 0; k < size; k++) {
                        Integer tree = placedTrees.pollFirst();
                        if (garden[i][j] >= tree) {
                            garden[i][j] -= tree;
                            placedTrees.addLast(tree + 1);
                        } else {
                            deadTrees[i][j].add(tree);
                        }
                    }
                }
            }
        }
        return deadTrees;
    }

}
