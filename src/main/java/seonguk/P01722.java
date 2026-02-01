package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01722 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int mode = Integer.parseInt(st.nextToken());
        if (mode == 1) {
            long target = Long.parseLong(st.nextToken());
            int[] ans = targetNum(target - 1);
            printArr(ans);
        } else {
            int[] target = new int[N];
            for (int i = 0; i < N; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(targetArr(target));
        }
    }

    private static void printArr(int[] ansArr) {
        StringBuilder sb = new StringBuilder();
        for (int num : ansArr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    static long targetArr(int[] arr) {
        long ans = 1l;
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            visited[arr[i]] = true;
            ans += countLowNum(visited, arr[i]) * calcFactorial(N - i - 1);
        }
        return ans;
    }

    static int countLowNum(boolean[] visited, int target) {
        int cnt = 0;
        for (int i = 1; i < target; i++) {
            if (!visited[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    static long calcFactorial(int num) {
        long ans = 1l;
        for (int i = 1; i <= num; i++) {
            ans = ans * i;
        }
        return ans;
    }

    static int[] targetNum(long target) {
        int[] result = new int[N];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            long fVal = calcFactorial(N - i - 1);
            long idx = target / fVal;

            int val = getVal(visited, idx);
            result[i] = val;
            if (val >= 0) {
                visited[val] = true;
            }

            target %= fVal;
        }
        return result;
    }

    private static int getVal(boolean[] visited, long idx) {
        long cnt = 0l;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (cnt == idx) {
                    return i;
                } else {
                    cnt++;
                }
            }
        }
        return -1;
    }
}
