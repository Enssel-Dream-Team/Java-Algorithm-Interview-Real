package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CyberOpeningGeneralAssembly_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String startTime = tokenizer.nextToken();
        String endTime = tokenizer.nextToken();
        String streamingEndTime = tokenizer.nextToken();
        HashSet<String> startCheck = new HashSet<>();
        HashSet<String> endCheck = new HashSet<>();
        while (true) {
            String input = reader.readLine();
            if (input == null) {
                break;
            }
            tokenizer = new StringTokenizer(input);
            String time = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            if (time.compareTo(startTime) <= 0) {
                startCheck.add(name);
            } else if (time.compareTo(endTime) >= 0 && time.compareTo(streamingEndTime) <= 0) {
                if (startCheck.contains(name)) {
                    endCheck.add(name);
                }
            }
        }
        System.out.println(endCheck.size());
    }
}
