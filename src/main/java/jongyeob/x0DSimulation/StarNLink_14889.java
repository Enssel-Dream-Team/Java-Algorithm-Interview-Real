package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StarNLink_14889 {
    private static int minGap = Integer.MAX_VALUE;
    private static int[][] scores;
    private static int[] teamStar;
    private static boolean[] isAdded;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        scores = new int[N][N];
        teamStar = new int[N / 2];
        isAdded = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                scores[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        simulation(0, N, 0);
        System.out.println(minGap);
    }

    private static void simulation(int start, int n, int depth) {
        if (depth == n / 2) {
            int teamStarScore = calculateScore(teamStar);
            int[] teamLink = new int[n / 2];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (!isAdded[i])
                    teamLink[index++] = i;
            }
            int teamLinkScore = calculateScore(teamLink);
            minGap = Math.min(minGap, Math.abs(teamStarScore - teamLinkScore));
            return;
        }
        for (int i = start; i < n; i++) {
            if (!isAdded[i]) {
                isAdded[i] = true;
                teamStar[depth] = i;
                simulation(i + 1, n, depth + 1);
                isAdded[i] = false;
            }
        }
    }

    private static int calculateScore(int[] team) {
        int sum = 0;
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < team.length; j++) {
                if (i == j)
                    continue;
                sum += scores[team[i]][team[j]];
            }
        }
        return sum;
    }
}
