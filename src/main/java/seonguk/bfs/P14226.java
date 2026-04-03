package seonguk.bfs;

import java.util.*;

public class P14226 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();

        Deque<Emoticon> que = new LinkedList<>();
        que.addLast(new Emoticon(1, 0, 0));
        int ans = -1;
        while (!que.isEmpty()) {
            Emoticon emoticon = que.pollFirst();
            if (emoticon.cnt == S) {
                ans = emoticon.time;
                break;
            }

            Emoticon next = emoticon.copyEmoticon();
            if (next != null) {
                que.addLast(next);
            }

            next = emoticon.pasteEmoticon();
            if (next != null) {
                que.addLast(next);
            }

            next = emoticon.removeEmoticon();
            if (next != null) {
                que.addLast(next);
            }
        }

        System.out.println(ans);
        scan.close();
    }

    static class Emoticon {

        private static Set<Emoticon> set = new HashSet<>();

        int cnt;
        int clipboard;
        int time;

        public Emoticon(int cnt, int clipboard, int time) {
            this.cnt = cnt;
            this.clipboard = clipboard;
            this.time = time;
        }

        public Emoticon copyEmoticon() {
            Emoticon emoticon = new Emoticon(cnt, cnt, time + 1);
            if (set.contains(emoticon)) {
                return null;
            }
            set.add(emoticon);
            return emoticon;
        }

        public Emoticon pasteEmoticon() {
            Emoticon emoticon = new Emoticon(cnt + clipboard, clipboard, time + 1);
            if (clipboard == 0 || set.contains(emoticon)) {
                return null;
            }
            set.add(emoticon);
            return emoticon;
        }

        public Emoticon removeEmoticon() {
            Emoticon emoticon = new Emoticon(cnt - 1, clipboard, time + 1);
            if (cnt < 1 || set.contains(emoticon)) {
                return null;
            }
            set.add(emoticon);
            return emoticon;
        }

        @Override
        public int hashCode() {
            return cnt * 1000000 + clipboard * 1000 + time;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Emoticon emoticon = (Emoticon) o;
            return cnt == emoticon.cnt && clipboard == emoticon.clipboard && time == emoticon.time;
        }
    }
}
