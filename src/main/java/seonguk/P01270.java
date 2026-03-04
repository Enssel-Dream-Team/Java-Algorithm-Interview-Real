package seonguk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P01270 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Long, Integer> map = new HashMap<>();
            int cnt = 0;
            while (st.hasMoreTokens()) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
            }

            boolean flag = false;
            int center = cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= center) {
                    bw.write(entry.getKey() + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("SYJKGW\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
