package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MovingThePipe1_17070 {
    private static int N;
    private static int count = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int currentX = 1;
        int currentY = 0;

        N = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        map[0][0] = -1;
        map[0][1] = -1;
        dfs(currentY, currentX, 0);
        System.out.println(count);
    }

    private static void dfs(int currentY, int currentX, int degree) {
        if (currentY == N - 1 && currentX == N - 1) {
            count++;
            return;
        }
        List<PositionInfo> nextPos = new ArrayList<>();
        if (degree == 0) {
            nextPos.add(new PositionInfo(currentY, currentX + 1, 0));
            nextPos.add(new PositionInfo(currentY + 1, currentX + 1, 45));
        } else if (degree == 45) {
            nextPos.add(new PositionInfo(currentY, currentX + 1, 0));
            nextPos.add(new PositionInfo(currentY + 1, currentX + 1, 45));
            nextPos.add(new PositionInfo(currentY + 1, currentX, 90));
        } else {
            nextPos.add(new PositionInfo(currentY + 1, currentX + 1, 45));
            nextPos.add(new PositionInfo(currentY + 1, currentX, 90));
        }
        for (PositionInfo next : nextPos) {
            int x = next.x;
            int y = next.y;
            if (x < N && y < N && map[y][x] != 1) {
                if ((next.degree == 45 && scanNear(x, y)) || next.degree != 45) {
                    dfs(y, x, next.degree);
                }
            }
        }
    }

    private static boolean scanNear(int x, int y) {
        if (x - 1 >= 0 && map[y][x - 1] == 1)
            return false;
        if (y - 1 >= 0 && map[y - 1][x] == 1)
            return false;
        return true;
    }

    private static class PositionInfo {
        int x, y, degree;

        public PositionInfo(int y, int x, int degree) {
            this.y = y;
            this.x = x;
            this.degree = degree;
        }
    }
}
