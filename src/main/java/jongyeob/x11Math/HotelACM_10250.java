package jongyeob.x11Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HotelACM_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < t; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            System.out.println(calculateRoomNumber(tokenizer));
        }
    }

    private static int calculateRoomNumber(StringTokenizer tokenizer) {
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int roomHeight = (n - 1) % h + 1;
        int roomNumber = (n - 1) / h + 1;
        return (roomHeight * 100) + roomNumber;
    }
}
