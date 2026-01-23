package jongyeob.x18Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lie_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer>[] partyParticipantList = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            partyParticipantList[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] peopleConnection = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            peopleConnection[i] = new ArrayList<>();
        }
        boolean[] knownTruth = new boolean[n + 1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = Integer.parseInt(tokenizer.nextToken()); i > 0; i--) {
            int people = Integer.parseInt(tokenizer.nextToken());
            knownTruth[people] = true;
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int count = Integer.parseInt(tokenizer.nextToken());
            if (count == 1) {
                partyParticipantList[i].add(Integer.parseInt(tokenizer.nextToken()));
            } else {
                int previous = Integer.parseInt(tokenizer.nextToken());
                partyParticipantList[i].add(previous);
                for (int j = 1; j < count; j++) {
                    int current = Integer.parseInt(tokenizer.nextToken());
                    partyParticipantList[i].add(current);
                    peopleConnection[current].add(previous);
                    peopleConnection[previous].add(current);
                    previous = current;
                }
            }
        }

        spreadKnown(n, peopleConnection, knownTruth);
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean canFake = true;
            for (Integer participant : partyParticipantList[i]) {
                if (knownTruth[participant]) {
                    canFake = false;
                    break;
                }
            }
            if (canFake) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void spreadKnown(int n, ArrayList<Integer>[] peopleConnection, boolean[] knownTruth) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (knownTruth[i])
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer people : peopleConnection[current]) {
                if (!knownTruth[people]) {
                    knownTruth[people] = true;
                    queue.add(people);
                }
            }
        }
    }
}
