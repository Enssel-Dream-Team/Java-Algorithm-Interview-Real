package seonguk.bfs;

import java.io.*;
import java.util.*;

public class P17471 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] populations = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> cities = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> city = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                city.add(Integer.parseInt(st.nextToken()) - 1);
            }
            cities.add(city);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < Math.pow(2, N) - 1; i++) {
            boolean[] isA = new boolean[N];

            String bin = Integer.toBinaryString(i);
            bin = "0".repeat(N - bin.length()) + bin;
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') {
                    isA[j] = true;
                }
            }

            if (checkArea(cities, isA)) {
                int totalA = 0;
                int totalB = 0;
                for (int j = 0; j < N; j++) {
                    if (isA[j]) {
                        totalA += populations[j];
                    } else {
                        totalB += populations[j];
                    }
                }

                ans = Math.min(ans, Math.abs(totalA - totalB));
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

        br.close();
    }

    private static boolean checkArea(List<List<Integer>> cities, boolean[] isA) {
        boolean[] visited = new boolean[N];
        int cntA = 0;
        int cntB = 0;

        for (int i = 0; i < N; i++) {
            if (isA[i]) {
                visited[i] = true;
                cntA = visitArea(cities, isA, visited, i);
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!isA[i]) {
                visited[i] = true;
                cntB = visitArea(cities, isA, visited, i);
                break;
            }
        }

        return cntA + cntB == N;
    }

    private static int visitArea(List<List<Integer>> cities, boolean[] isA, boolean[] visited, int start) {
        int cnt = 1;
        Deque<Integer> que = new LinkedList<>();
        que.addLast(start);
        while (!que.isEmpty()) {
            int val = que.pollFirst();
            for (int next : cities.get(val)) {
                if (!visited[next] && isA[next] == isA[start]) {
                    que.addLast(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
