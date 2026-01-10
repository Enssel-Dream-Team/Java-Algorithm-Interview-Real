package jongyeob.x17PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java. io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SayMiddle_1655 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(reader.readLine());
            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(current);
            }else{
                minHeap.add(current);
            }
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                Integer maxPoll = maxHeap.poll();
                Integer minPoll = minHeap.poll();
                minHeap.add(maxPoll);
                maxHeap.add(minPoll);
            }
            System.out.println(maxHeap.peek());
        }
    }
}
