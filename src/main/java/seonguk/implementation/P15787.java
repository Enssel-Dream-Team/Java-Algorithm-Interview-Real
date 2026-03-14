package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class P15787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Train[] trains = new Train[N];
        for (int i = 0; i < N; i++) {
            trains[i] = new Train();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int idx = -1;
            if (command <= 2) {
                idx = Integer.parseInt(st.nextToken());
            }

            doCommand(trains, command, num, idx);
        }

        HashSet<Train> set = new HashSet<>(Arrays.asList(trains));
        System.out.println(set.size());
        br.close();
    }

    static void doCommand(Train[] trains, int command, int num, int idx) {
        switch (command) {
            case 1:
                trains[num].setSeat(idx);
                break;
            case 2:
                trains[num].removeSeat(idx);
                break;
            case 3:
                trains[num].moveBack();
                break;
            default:
                trains[num].moveForward();
        }
    }

    static class Train {
        boolean[] seats;

        Train() {
            seats = new boolean[22];
        }

        void setSeat(int row) {
            seats[row] = true;
        }

        void removeSeat(int row) {
            seats[row] = false;
        }

        void moveBack() {
            for (int i = 21; i > 0; i--) {
                seats[i] = seats[i - 1];
            }
            seats[21] = false;
        }

        void moveForward() {
            for (int i = 0; i < 21; i++) {
                seats[i] = seats[i + 1];
            }
            seats[0] = false;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Train train = (Train) o;
            return Objects.deepEquals(seats, train.seats);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(seats);
        }
    }
}
