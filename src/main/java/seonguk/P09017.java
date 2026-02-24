package seonguk;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.*;

public class P09017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                arr[i] = team;
                map.put(team, map.getOrDefault(team, 0) + 1);
            }

            Map<Integer, Team> teams = new HashMap<>();
            int score = 1;
            for (int i = 0; i < N; i++) {
                int teamNumber = arr[i];
                if (map.get(teamNumber) == 6) {
                    Team team = teams.getOrDefault(teamNumber, new Team());
                    team.add(score++);
                    teams.put(teamNumber, team);
                }
            }

            int ans = -1;
            int minScore = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Team> entry : teams.entrySet()) {
                int s = entry.getValue().score();
                if (s < minScore) {
                    minScore = s;
                    ans = entry.getKey();
                } else if (s == minScore) {
                    int oriFive = teams.get(ans).getFive();
                    int compFive = entry.getValue().getFive();
                    if (oriFive > compFive) {
                        ans = entry.getKey();
                    }
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Team {
        List<Integer> scores;

        public Team() {
            scores = new ArrayList<>();
        }

        public void add(int score) {
            scores.add(score);
        }

        public int score() {
            int result = 0;
            for (int i = 0; i < 4; i++) {
                result += scores.get(i);
            }
            return result;
        }

        public int getFive() {
            return scores.get(4);
        }
    }
}
