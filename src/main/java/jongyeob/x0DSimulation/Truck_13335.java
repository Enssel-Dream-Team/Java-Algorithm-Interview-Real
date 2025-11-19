package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Truck_13335 {
    private static int N, W, L;
    private static int roadWeight = 0;
    private static int[] trucks;
    private static Queue<Integer> road = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        W = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());
        trucks = new int[N];
        for (int i = 0; i < W; i++) {
            road.add(0);
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        int time = 0;
        for (int i = 0; i < N; i++) {
            int current = trucks[i];
            boolean isAdded = false;
            while (roadWeight + current > L) {
                roadWeight -= road.poll();
                time++;
                if (roadWeight + current <= L) {
                    isAdded = true;
                    road.add(current);
                    roadWeight += current;
                    break;
                }
                road.add(0);
            }
            if (!isAdded) {
                roadWeight -= road.poll();
                time++;
                road.add(current);
                roadWeight += current;
            }
        }
        while (roadWeight != 0) {
            roadWeight -= road.poll();
            time++;
        }
        return time;
    }

}
