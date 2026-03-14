package seonguk.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P16922 {

    static int[] romeNumber = {1, 5, 10, 50};

    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        set = new HashSet<>();

        recursion(0, 0, 1, N);

        System.out.println(set.size());
        scan.close();
    }

    static void recursion(int idx, int val, int cnt, int target) {
        for (int i = idx; i < 4; i++) {
            if (cnt == target) {
                set.add(val + romeNumber[i]);
            } else {
                recursion(i, val + romeNumber[i], cnt + 1, target);
            }
        }
    }
}
