package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P01111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (checkSizeTwo(arr)) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int a = -100; a <= 100; a++) {
            int b = calcB(arr[0], arr[1], a);
            if (checkLogic(arr, a, b)) {
                set.add(calc(arr[N - 1], a, b));
            }
        }

        if (set.isEmpty()) {
            System.out.println("B");
        } else if (set.size() > 1) {
            System.out.println("A");
        } else {
            System.out.println(set.iterator().next());
        }
        br.close();
    }

    static boolean checkLogic(int[] arr, int a, int b) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (calc(arr[i], a, b) != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static int calcB(int before, int after, int a) {
        return after - before * a;
    }

    static int calc(int before, int a, int b) {
        return before * a + b;
    }

    static boolean checkSizeTwo(int[] arr) {
        if (arr.length > 2) {
            return false;
        }

        if (arr.length == 1 || arr[0] != arr[1]) {
            System.out.println("A");
        } else {
            System.out.println(arr[0]);
        }

        return true;
    }
}
