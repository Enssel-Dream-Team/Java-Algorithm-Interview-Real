package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class PopulationMovement_16234 {
    private static final int[][] nearCountryDistance = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n, l, r;
    private static int[][] population;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        l = Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());

        population = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                population[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int result = simulation();
        System.out.println(result);

    }

    private static int simulation() {
        int count = 0;
        while (true) {
            count++;
            boolean isMoved = false;
            isVisited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j] && checkPopulation(i, j)) {
                        isMoved = true;
                    }
                }
            }
            if (!isMoved) {
                break;
            }
        }
        return count - 1;
    }

    private static boolean checkPopulation(int y, int x) {
        int sumOfPopulation = 0;
        Queue<Country> queue = new ArrayDeque<>();
        Stack<Country> stack = new Stack<>();
        queue.add(new Country(y, x, population[y][x]));
        isVisited[y][x] = true;
        while (!queue.isEmpty()) {
            Country currentCountry = queue.poll();
            sumOfPopulation += currentCountry.population;
            stack.add(currentCountry);
            for (int[] position : nearCountryDistance) {
                int nextY = currentCountry.y + position[0];
                int nextX = currentCountry.x + position[1];
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !isVisited[nextY][nextX]) {
                    int nearCountryPopulation = population[nextY][nextX];
                    int populationGap = Math.abs(currentCountry.population - nearCountryPopulation);
                    if (populationGap >= l && populationGap <= r) {
                        isVisited[nextY][nextX] = true;
                        Country nextCountry = new Country(nextY, nextX, population[nextY][nextX]);
                        queue.add(nextCountry);
                    }
                }
            }
        }
        if (stack.size() > 1) {
            int newPopulation = sumOfPopulation / stack.size();
            while (!stack.isEmpty()) {
                Country country = stack.pop();
                population[country.y][country.x] = newPopulation;
            }
            return true;
        }
        return false;
    }

    private static class Country {
        int x;
        int y;
        int population;

        public Country(int y, int x, int population) {
            this.y = y;
            this.x = x;
            this.population = population;
        }
    }
}
