package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P02304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Frame> list = new ArrayList<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Frame(idx, height));
        }

        Collections.sort(list);

        int left = 0;
        Frame leftMaxFrame = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Frame currentFrame = list.get(i);
            if (currentFrame.height > leftMaxFrame.height) {
                left += leftMaxFrame.height * (currentFrame.idx - leftMaxFrame.idx);
                leftMaxFrame = currentFrame;
            }
        }

        int right = 0;
        Frame rightMaxFrame = list.get(list.size() - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            Frame currentFrame = list.get(i);
            if (currentFrame.idx < leftMaxFrame.idx) {
                break;
            }

            if (currentFrame.height > rightMaxFrame.height) {
                right += rightMaxFrame.height * (rightMaxFrame.idx - currentFrame.idx);
                rightMaxFrame = currentFrame;
            }
        }

        int ans = left + right + leftMaxFrame.height * (rightMaxFrame.idx - leftMaxFrame.idx + 1);
        System.out.println(ans);
        br.close();
    }

    static class Frame implements Comparable<Frame> {
        int idx;
        int height;

        public Frame(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public int compareTo(Frame o) {
            return this.idx - o.idx;
        }
    }
}
