package seonguk.bfs;

import java.util.*;

public class P25418 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int K = scan.nextInt();

        Set<Integer> set = new HashSet<>();
        set.add(A);

        Deque<Num> queue = new ArrayDeque<>();
        queue.addLast(new Num(A, 0));
        while (!queue.isEmpty()) {
            Num num = queue.pollFirst();
            if (num.val == K) {
                System.out.println(num.cnt);
                break;
            }

            Num next1 = num.add();
            Num next2 = num.multi();

            if (!set.contains(next1.val) && next1.val <= K) {
                set.add(next1.val);
                queue.addLast(next1);
            }
            if (!set.contains(next2.val) && next2.val <= K) {
                set.add(next2.val);
                queue.addLast(next2);
            }
        }
        scan.close();
    }

    static class Num {
        int val;
        int cnt;

        public Num (int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        public Num add () {
            return new Num(val + 1, cnt + 1);
        }

        public Num multi() {
            return new Num(val * 2, cnt + 1);
        }
    }
}
