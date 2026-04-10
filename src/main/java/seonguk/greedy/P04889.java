package seonguk.greedy;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class P04889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = 0;

        while (!str.contains("-")) {
            Deque<Character> stack = new LinkedList<>();
            int ans = 0;
            for (char c : str.toCharArray()) {
                if (stack.isEmpty() && c == '}') {
                    ans++;
                    stack.push('{');
                    continue;
                }

                if (c == '{') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            ans += stack.size() / 2;
            bw.write(++num + ". " + ans + "\n");
            str = br.readLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
