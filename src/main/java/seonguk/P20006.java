package seonguk;

import java.io.*;
import java.util.*;

public class P20006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player player = new Player(nickname, level);

            boolean enter = false;
            for (Room room : rooms) {
                if (room.checkEnter(player)) {
                    room.enterRoom(player);
                    enter = true;
                    break;
                }
            }

            if (!enter) {
                rooms.add(new Room(m, player));
            }
        }

        for (Room room : rooms) {
            bw.write(room.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Room {
        int capacity;
        int minLevel, maxLevel;
        List<Player> players;
        int idx = 0;

        Room(int capacity, Player player) {
            this.capacity = capacity;
            players = new ArrayList<>();
            minLevel = player.level - 10;
            maxLevel = player.level + 10;
            enterRoom(player);
        }

        private boolean checkEnter(Player player) {
            if (idx == capacity) {
                return false;
            }

            if (player.level < minLevel || player.level > maxLevel) {
                return false;
            }

            return true;
        }

        public void enterRoom(Player player) {
            players.add(player);
            idx++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (idx == capacity) {
                sb.append("Started!");
            } else {
                sb.append("Waiting!");
            }
            sb.append("\n");

            Collections.sort(players);
            for (Player player : players) {
                sb.append(player).append("\n");
            }
            return sb.toString();
        }
    }

    static class Player implements Comparable<Player> {
        String nickname;
        int level;

        Player(String nickname, int level) {
            this.nickname = nickname;
            this.level = level;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }
    }
}
