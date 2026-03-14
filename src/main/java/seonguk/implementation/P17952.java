package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P17952 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Report> stack = new LinkedList<>();
        int ans = 0;
        Report r = null;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int score = Integer.parseInt(st.nextToken());
                int minutes = Integer.parseInt(st.nextToken());

                if (r != null) {
                    stack.addLast(r);
                }

                r = new Report(score, minutes);
                if (r.minutes == 0) {
                    ans += r.score;
                    if (!stack.isEmpty()) {
                        r = stack.pollLast();
                    } else {
                        r = null;
                    }
                }
            } else {
                if (r != null) {
                    int score = r.doReport();
                    if (score >= 0) {
                        ans += score;
                        if (!stack.isEmpty()) {
                            r = stack.pollLast();
                        } else  {
                            r = null;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    static class Report {
        int score;
        int minutes;

        public Report(int score, int minute) {
            this.score = score;
            this.minutes = minute - 1;
        }

        public int doReport() {
            minutes--;

            if (minutes > 0) {
                return -1;
            }
            return score;
        }
    }
}
