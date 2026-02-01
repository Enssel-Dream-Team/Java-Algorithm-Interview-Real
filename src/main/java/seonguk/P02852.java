package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02852 {

    static final int LAST_TIME = 48 * 60;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Score[] scores = new Score[3];
        scores[1] = new Score();
        scores[2] = new Score();

        int before = 0;
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            int parsedTime = parseTime(time);
            int diff = parsedTime - before;

            compare(scores, team, diff);
            before = parsedTime;
        }

        int diff = LAST_TIME - before;
        compare(scores, null, diff);

        StringBuilder sb = new StringBuilder();
        sb.append(scores[1].getResultTime()).append("\n");
        sb.append(scores[2].getResultTime()).append("\n");
        System.out.println(sb);

        br.close();
    }

    static void compare(Score[] scores, Integer team, int time) {
        Score score1 = scores[1];
        Score score2 = scores[2];
        if (score1.score > score2.score) {
            score1.addSeconds(time);
        } else if (score1.score < score2.score) {
            score2.addSeconds(time);
        }

        if (team != null) {
            scores[team].getScore();
        }
    }

    static int parseTime(String time) {
        String[] arr = time.split(":");
        int minutes = Integer.parseInt(arr[0]);
        int seconds = Integer.parseInt(arr[1]);
        return minutes * 60 + seconds;
    }

    static class Score {
        int score;
        int totalSeconds;

        void getScore() {
            score++;
        }

        void addSeconds(int seconds) {
            totalSeconds += seconds;
        }

        String getResultTime() {
            String minutes = String.valueOf(totalSeconds / 60);
            String seconds = String.valueOf(totalSeconds % 60);

            return formatTime(minutes) + ":" + formatTime(seconds);
        }

        private String formatTime(String str) {
            if (str.length() < 2) {
                str = "0" + str;
            }

            return str;
        }
    }
}
