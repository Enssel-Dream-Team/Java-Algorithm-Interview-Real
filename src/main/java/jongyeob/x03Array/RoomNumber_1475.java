package jongyeob.x03Array;

import java.util.Scanner;

public class RoomNumber_1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in );
        int input = scanner.nextInt();
        int result = solve(input);
        System.out.println(result);
    }

    public static int solve(int input) {
        int[] numbers = new int[10];
        extractNumbers(input, numbers);
        int sum6And9 = numbers[6] + numbers[9];
        return getNeeds(numbers, sum6And9);
    }

    private static int getNeeds(int[] numbers, int sum6And9) {
        int maxValue = 0;
        for(int i = 0 ;  i < 10; i++){
            if(i == 6 || i == 9)
                continue;
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        int needs6And9 = (int)Math.ceil(sum6And9 * 0.5);
        if(maxValue > sum6And9 / 2)
            return maxValue;
        else
            return needs6And9;
    }

    private static void extractNumbers(int input, int[] numbers) {
        while(input != 0 ){
            numbers[input %10]++;
            input /= 10;
        }
    }
}
